package bzu.lgx.bf.controller;

import bzu.lgx.bf.commons.Result;
import bzu.lgx.bf.commons.StatusCode;
import bzu.lgx.bf.entity.Admin;
import bzu.lgx.bf.security.JwtAuthenticationToken;
import bzu.lgx.bf.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-28 17:31
 * @Description:
 */
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public Result login(@RequestBody Admin admin, HttpServletRequest request){
        JwtAuthenticationToken token = SecurityUtils.login(request, admin.getUsername(), admin.getPassword(), authenticationManager);
        return new Result(true, StatusCode.SUCCESS, "登录成功", token);
    }

}
