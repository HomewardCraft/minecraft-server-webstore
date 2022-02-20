package com.homeward.webstore.common.util;

import com.homeward.webstore.common.consts.SystemConst;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.homeward.webstore.common.enums.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class JwtUtils {
    /**
     * 密钥
     */
    private static final String SECRET = SystemConst.PROJECT_NAME.getInformation() + "_xxBAIORETTOxx";

    /**
     * 过期时间(单位: 毫秒)
     **/
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;

    /**
     * 刷新时间(单位: 毫秒)
     */
    private static final long REFRESH_TIME = 1 * 24 * 60 * 60 * 1000;

    /**
     * 存入请求头的key
     */
    private static final String HEADER_KEY = "Authorization";

    /**
     * 前缀
     */
    private static final String PREFIX = "Bearer ";

    /**
     * userId
     */
    private static final String UUID = "uuid";

    /**
     * 生成token,设置token超时时间
     *
     * @param uuid uuid
     * @return json web token
     */
    public static String createToken(String uuid) {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        return JWT.create()
                // 添加头部
                .withHeader(map)
                // 放入用户的id
                .withAudience(String.valueOf(uuid))
                // 可以将基本信息放到claims中
                .withClaim(UUID, uuid)
                // 超时设置,设置过期的日期
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                // 签发时间
                .withIssuedAt(new Date())
                // SECRET加密
                .sign(Algorithm.HMAC256(SECRET));
    }


    /**
     * 获取用户userId
     * @return uuid
     */
    public static String getUUID() {
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();

        String token = request.getHeader(HEADER_KEY);
        if (StringUtils.isBlank(token)) {
            CommonUtils.throwRuntimeException(StatusEnum.JWT_NOT_FOUND);
        }
        if (!token.startsWith(PREFIX)) {
            CommonUtils.throwRuntimeException(StatusEnum.WRONG_PREFIX);
        }
        token = token.replace(PREFIX, "");
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            if (jwt == null) {
                CommonUtils.throwRuntimeException(StatusEnum.JWT_HAS_EXPIRED);
            }
            return jwt.getClaim(UUID).asString();
        } catch (Exception e) {
            log.error("token verified error, {}", e.getMessage());
        }
        throw new RuntimeException(StatusEnum.JWT_HAS_EXPIRED.getMessage());
    }


    /**
     * 校验token
     * @return boolean
     */
    public static boolean verity() {
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        // 从请求头部中获取token信息
        String token = request.getHeader(HEADER_KEY);
        if (StringUtils.isBlank(token)) {
            return false;
        }
        if (!token.startsWith(PREFIX)) {
            CommonUtils.throwRuntimeException(StatusEnum.WRONG_PREFIX);
        }
        token = token.replace(PREFIX, "");
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            if (null == jwt) {
                return false;
            }
            // 判断过期时间
            long time = (jwt.getExpiresAt().getTime() - System.currentTimeMillis());
            // 有效期只有不到60分钟，需要刷新token了
            if (REFRESH_TIME > time) {
                String newToken = createToken(jwt.getClaim(UUID).asString());
                // 将新的token放入响应请求头中
                SpringContextUtils.getHttpServletResponse().setHeader(HEADER_KEY, newToken);
            }
            return true;
        } catch (Exception e) {
            log.error("token verified error, {}", e.getMessage());
        }
        return false;
    }
}