package bzu.lgx.bf.utils;

import javax.servlet.http.HttpServletRequest;

import bzu.lgx.bf.security.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;


/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-28 17:31
 * @Description:
 */
public class SecurityUtils {


    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-28 18:23
     * @Params: request
     * @Params: username
     * @Params: password
     * @Params: authenticationManager
     * @Return: JwtAuthenticationToken
     * @Description: 系统登录认证
     */
    public static JwtAuthenticationToken login(HttpServletRequest request, String username, String password, AuthenticationManager authenticationManager) {
        JwtAuthenticationToken token = new JwtAuthenticationToken(username, password);
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // 执行登录认证过程
        Authentication authentication = authenticationManager.authenticate(token);
        // 认证成功存储认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 生成令牌并返回给客户端
        token.setToken(JwtTokenUtils.generateToken(authentication));
        return token;
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-28 18:42
     * @Params: request
     * @Return: void
     * @Description: 获取令牌进行认证
     */
    public static void checkAuthentication(HttpServletRequest request) {
        // 获取令牌并根据令牌获取登录认证信息
        Authentication authentication = JwtTokenUtils.getAuthenticationeFromToken(request);
        // 设置登录认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-28 18:42
     * @Return: java.lang.String
     * @Description: 获取当前用户名
     */
    public static String getUsername() {
        String username = null;
        Authentication authentication = getAuthentication();
        if(authentication != null) {
            Object principal = authentication.getPrincipal();
            if(principal != null && principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            }
        }
        return username;
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-28 18:43
     * @Params: authentication
     * @Return: java.lang.String
     * @Description: 获取用户名
     */
    public static String getUsername(Authentication authentication) {
        String username = null;
        if(authentication != null) {
            Object principal = authentication.getPrincipal();
            if(principal != null && principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            }
        }
        return username;
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-28 18:43
     * @Return: org.springframework.security.core.Authentication
     * @Description: 获取当前登录信息
     */
    public static Authentication getAuthentication() {
        if(SecurityContextHolder.getContext() == null) {
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
