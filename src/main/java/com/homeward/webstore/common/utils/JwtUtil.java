package com.homeward.webstore.common.utils;

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
public class JwtUtil {
    /**
     * 密钥
     */
    private static final String SECRET = SystemConst.SYSTEM_PROJECT_NAME.getName() + "_SunjiamuCaishangqi";

    /**
     * 过期时间（单位：秒）
     **/
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60;

    /**
     * 刷新时间（单位：秒）
     */
    private static final long REFRESH_TIME = 7 * 24 * 60 * 60;

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
    private static final String USERID = "userId";

    /**
     * 生成用户token,设置token超时时间
     *
     * @param userId user id
     * @return jwt
     */
    public static String createToken(String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        return JWT.create()
                // 添加头部
                .withHeader(map)
                // 放入用户的id
                .withAudience(String.valueOf(userId))
                // 可以将基本信息放到claims中
                .withClaim(USERID, userId)
                // 超时设置,设置过期的日期
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                // 签发时间
                .withIssuedAt(new Date())
                // SECRET加密
                .sign(Algorithm.HMAC256(SECRET));
    }


    /**
     * 获取用户userId
     * @return user id
     */
    public static String getUserId() {
        HttpServletRequest request = SpringContextUtil.getHttpServletRequest();

        String token = request.getHeader(HEADER_KEY);
        if (StringUtils.isBlank(token)) {
            CommonUtil.throwRuntimeException(StatusEnum.JWT_NOT_FOUND);
        }
        if (!token.startsWith(PREFIX)) {
            CommonUtil.throwRuntimeException(StatusEnum.WRONG_PREFIX);
        }
        token = token.replace(PREFIX, "");
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            if (jwt == null) {
                CommonUtil.throwRuntimeException(StatusEnum.JWT_HAS_EXPIRED);
            }
            return jwt.getClaim(USERID).asString();
        } catch (Exception e) {
            log.error("token verified error, {}", e.getMessage());
        }
        CommonUtil.throwRuntimeException(StatusEnum.JWT_HAS_EXPIRED);
        return null;
    }


    /**
     * 校验token
     * @return boolean
     */
    public static boolean verity() {
        HttpServletRequest request = SpringContextUtil.getHttpServletRequest();
        // 从请求头部中获取token信息
        String token = request.getHeader(HEADER_KEY);
        if (StringUtils.isBlank(token)) {
            return false;
        }
        if (!token.startsWith(PREFIX)) {
            CommonUtil.throwRuntimeException(StatusEnum.WRONG_PREFIX);
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
            if ((REFRESH_TIME - ((7 * 24 * 60 * 60) - (60 * 60))) > time) {
                String newToken = createToken(jwt.getClaim(USERID).asString());
                // 将新的token放入响应请求头中
                SpringContextUtil.getHttpServletResponse().setHeader(HEADER_KEY, newToken);
            }
            return true;
        } catch (Exception e) {
            log.error("token verified error, {}", e.getMessage());
        }
        return false;
    }
}
