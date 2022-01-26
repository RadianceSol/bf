package bzu.lgx.bf.controller;

import bzu.lgx.bf.commons.Result;
import bzu.lgx.bf.commons.StatusCode;
import bzu.lgx.bf.entity.Para;
import bzu.lgx.bf.service.ParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-20 16:43
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping("/para")
public class ParaController {

    @Autowired
    private ParaService paraService;

    @PostMapping
    public Result insert(@RequestBody Para para){
        paraService.insert(para);
        return new Result(true, StatusCode.SUCCESS, "添加参数成功");
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id){
        paraService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除参数成功");
    }

}
