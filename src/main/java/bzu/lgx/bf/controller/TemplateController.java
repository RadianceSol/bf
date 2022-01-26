package bzu.lgx.bf.controller;

import bzu.lgx.bf.commons.Result;
import bzu.lgx.bf.commons.StatusCode;
import bzu.lgx.bf.entity.Template;
import bzu.lgx.bf.service.TemplateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-20 11:40
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 16:41
     * @Params: template
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 添加模板
     */
    @PostMapping
    @ApiOperation(value = "添加模板", httpMethod = "POST")
    public Result insert(@ApiParam(name = "参数", value = "模板对象", required = true) @RequestBody Template template){
        templateService.insert(template);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 16:41
     * @Params: id
     * @Return: bzu.lgx.bf.commons.Result
     * @Description:  根据ID删除模板
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据ID删除模板", httpMethod = "DELETE")
    public Result deleteById(@ApiParam(name = "参数", value = "模板ID", required = true) @PathVariable String id){
        templateService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

}
