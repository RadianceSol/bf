package bzu.lgx.bf.controller;

import bzu.lgx.bf.commons.PageResult;
import bzu.lgx.bf.commons.Result;
import bzu.lgx.bf.commons.StatusCode;
import bzu.lgx.bf.entity.Admin;
import bzu.lgx.bf.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-27 11:40
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping("/admin")
@Api("About Admin API")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:45
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 查询全部管理员
     */
    @GetMapping
    @ApiOperation(value = "查询全部管理员", httpMethod = "GET")
    public Result findAll(){
        return new Result(true, StatusCode.SUCCESS, "查询成功", adminService.findAll());
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:46
     * @Params: id      管理员ID
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 根据ID查询管理员
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询管理员", httpMethod = "GET")
    public Result findById(@ApiParam(name = "参数", value = "管理员ID", required = true) @PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", adminService.findById(id));
    }

    /** FIXME: Need To Rewrite
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:46
     * @Params: searchMap
     * @Params: page
     * @Params: size
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 多条件分页查询
     */
    @GetMapping("/search/{page}/{size}")
    @ApiOperation(value = "多条件分页查询", httpMethod = "GET")
    public Result findSearch(@ApiParam(name = "参数", value = "条件封装", required = true) @RequestBody Map searchMap,
                             @ApiParam(name = "参数", value = "页码") @PathVariable int page,
                             @ApiParam(name = "参数", value = "页码大小") @PathVariable int size) {
        Page<Admin> pageList = adminService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.SUCCESS, "查询成功", new PageResult<Admin>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:59
     * @Params: searchMap 搜索条件
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 条件查询
     */
    @PostMapping("/search")
    @ApiOperation(value = "条件查询", httpMethod = "POST")
    public Result findSearch(@ApiParam(name = "参数", value = "搜索条件" , required = true) @RequestBody Map searchMap) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", adminService.findSearch(searchMap));
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 12:00
     * @Params: brand   品牌对象
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 添加管理员
     */
    @PostMapping
    @ApiOperation(value = "添加管理员", httpMethod = "POST")
    public Result insert(@ApiParam(name = "参数", value = "管理员对象", required = true) @RequestBody Admin admin) {
        adminService.insert(admin);
        return new Result(true, StatusCode.SUCCESS, "增加成功");
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 12:04
     * @Params: admin
     * @Params: id
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 修改管理员
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "修改管理员", httpMethod = "PUT")
    public Result update(@ApiParam(name = "参数", value = "管理员对象") @RequestBody Admin admin,
                         @ApiParam(name = "参数", value = "管理员ID", required = true) @PathVariable String id) {
        admin.setId(id);
        adminService.updata(admin);
        return new Result(true, StatusCode.SUCCESS, "修改成功");
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 12:05
     * @Params: id
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 根据ID删除管理员
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据ID删除管理员", httpMethod = "DELETE")
    public Result delete(@ApiParam(name = "参数", value = "管理员ID", required = true) @PathVariable String id) {
        adminService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

}
