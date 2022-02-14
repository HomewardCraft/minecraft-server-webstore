package com.homeward.webstore.common.utils;

import com.homeward.webstore.common.consts.SystemConst;
import com.homeward.webstore.common.exceptions.UnLoginException;
import com.homeward.webstore.common.utils.SpringContextUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
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
    private static final String SECRET = SystemConst.SYSTEM_ITEM_NAME + "_secret";

    /**
     * 过期时间（单位：秒）
     **/
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60;

    /**
     * 刷新时间（单位：秒）
     */
    private static final long REFRESH_TIME = 1 * 24 * 60 * 60;

    /**
     * 存入请求头的key
     */
    private static final String HEADER_KEY = "Authorization";

    /**
     * 前缀
     */
    private static final String PREFIX = "Bearer ";

    /**
     * 存入claim的key1
     */
    private static final String claimKey1 = "userId";

    /**
     * 存入claim的key1
     */
    private static final String claimKey2 = "phone";

    /**
     * 生成用户token,设置token超时时间
     *
     * @param userId
     * @return
     */
    public static String createToken(Integer userId, String phone) {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                // 添加头部
                .withHeader(map)
                // 放入用户的id
                .withAudience(String.valueOf(userId))
                // 可以将基本信息放到claims中
                .withClaim(claimKey1, userId)
                .withClaim(claimKey2, phone)
                // 超时设置,设置过期的日期
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME * 1000))
                // 签发时间
                .withIssuedAt(new Date())
                // SECRET加密
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /**
     * 获取用户userId
     *
     * @return
     */
    public static Integer getUserId() {
        HttpServletRequest request = SpringContextUtil.getHttpServletRequest();
        // 从请求头部中获取token信息
        String token = request.getHeader(HEADER_KEY);
        if (StringUtils.isBlank(token)) {
            return null;
        }
        if (!token.startsWith(PREFIX)) {
            throw new UnLoginException("错误的令牌信息，请重新登录！");
        }
        token = token.replace(PREFIX, "");
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            if (null == jwt) {
                throw new UnLoginException("登录信息已过期，请重新登录！");
            }
            // 用户id
            return jwt.getClaim(claimKey1).asInt();
        } catch (Exception e) {
            log.error("token验证异常，{}", e.getMessage());
        }
        throw new UnLoginException("登录信息已过期，请重新登录！");
    }

    /**
     * 获取用户account
     *
     * @return
     */
    public static String getPhone() {
        HttpServletRequest request = SpringContextUtil.getHttpServletRequest();
        // 从请求头部中获取token信息
        String token = request.getHeader(HEADER_KEY);
        if (StringUtils.isBlank(token)) {
            return null;
        }
        if (!token.startsWith(PREFIX)) {
            throw new UnLoginException("错误的令牌信息，请重新登录！");
        }
        token = token.replace(PREFIX, "");
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            if (null == jwt) {
                throw new UnLoginException("登录信息已过期，请重新登录！");
            }
            // 用户id
            return jwt.getClaim(claimKey2).asString();
        } catch (Exception e) {
            log.error("token验证异常，{}", e.getMessage());
        }
        throw new UnLoginException("登录信息已过期，请重新登录！");
    }

    /**
     * 检验token
     *
     * @return
     */
    public static boolean verity() {
        HttpServletRequest request = SpringContextUtil.getHttpServletRequest();
        // 从请求头部中获取token信息
        String token = request.getHeader(HEADER_KEY);
        if (StringUtils.isBlank(token)) {
            return false;
        }
        if (!token.startsWith(PREFIX)) {
            throw new UnLoginException("错误的令牌信息，请重新登录！");
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
            // 有效期只有10分钟，需要刷新token了
            if ((REFRESH_TIME * 1000) > time) {
                String newToken = createToken(jwt.getClaim(claimKey1).asInt(), jwt.getClaim(claimKey2).asString());
                // 将新的token放入响应请求头中
                SpringContextUtil.getHttpServletResponse().setHeader(HEADER_KEY, newToken);
            }
            return true;
        } catch (Exception e) {
            log.error("token验证异常，{}", e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(createToken(8, "oALoT6I1SNVuSp6Gp1p8UvXA36fE"));
    }

}
