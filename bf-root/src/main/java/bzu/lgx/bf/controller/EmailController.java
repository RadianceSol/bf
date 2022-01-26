package bzu.lgx.bf.controller;

import bzu.lgx.bf.commons.Result;
import bzu.lgx.bf.commons.StatusCode;
import bzu.lgx.bf.utils.EmailCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-26 16:58
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping("/mail")
public class EmailController {

    @GetMapping("/send")
    public Result sendMail(){
        new EmailCode().sendMail();
        return new Result(true, StatusCode.SUCCESS, "发送成功");
    }

}
