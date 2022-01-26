package bzu.lgx.bf.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-18 18:52
 * @Description: 统一异常处理类
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        System.out.println("Base Exception Handler");
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }

}
