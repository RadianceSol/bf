package bzu.lgx.bf.controller;

import bzu.lgx.bf.commons.Result;
import bzu.lgx.bf.commons.StatusCode;
import bzu.lgx.bf.entity.Spec;
import bzu.lgx.bf.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-20 15:14
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping("/spec")
public class SpecController {

    @Autowired
    private SpecService specService;

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 16:28
     * @Params: spec
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 添加规格
     */
    @PostMapping
    public Result insert(@RequestBody Spec spec){
        specService.insert(spec);
        return new Result(true, StatusCode.SUCCESS, "添加规格成功");
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 16:29
     * @Params: id
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 根据ID删除规格
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id){
        specService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除规格成功");
    }
}
