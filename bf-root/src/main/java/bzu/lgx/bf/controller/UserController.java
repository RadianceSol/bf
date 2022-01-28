package bzu.lgx.bf.controller;

import bzu.lgx.bf.commons.Result;
import bzu.lgx.bf.commons.StatusCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-28 19:14
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping("/findAll")
    public Result findAll(){
        return new Result(true, StatusCode.SUCCESS, "the findAll service is called success");
    }

    @PreAuthorize("hasAuthority('sys:user:edit')")
    @GetMapping(value="/edit")
    public Result edit(){
        return new Result(true, StatusCode.SUCCESS, "the edit service is called success");
    }

    @PreAuthorize("hasAuthority('sys:user:delete')")
    @GetMapping(value="/delete")
    public Result delete(){
        return new Result(true, StatusCode.SUCCESS, "the delete service is called success");
    }

}
