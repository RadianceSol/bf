package bzu.lgx.bf.controller;

import bzu.lgx.bf.commons.PageResult;
import bzu.lgx.bf.commons.Result;
import bzu.lgx.bf.commons.StatusCode;
import bzu.lgx.bf.entity.Brand;
import bzu.lgx.bf.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-08 16:46
 * @Description: 品牌数据控制层
 */
@CrossOrigin
@RestController
@RequestMapping("/brand")
@Api("About Brand API")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-09 08:50
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 查询全部品牌
     */
    @GetMapping
    @ApiOperation(value = "查询全部品牌", httpMethod = "GET")
    public Result findAll(){
        return new Result(true, StatusCode.SUCCESS, "查询成功", brandService.findAll());
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-09 08:52
     * @Params: id          品牌ID
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 根据ID查询品牌
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询品牌", httpMethod = "GET")
    public Result findById(@ApiParam(name = "参数", value = "品牌ID", required = true) @PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", brandService.findById(id));
    }

    /** FIXME: Need To Rewrite
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-09 08:55
     * @Params: searchMap   查询条件封装
     * @Params: page        页码
     * @Params: size        页大小
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 多条件分页查询
     */
    @GetMapping("/search/{page}/{size}")
    @ApiOperation(value = "多条件分页查询", httpMethod = "GET")
    public Result findSearch(@ApiParam(name = "参数", value = "条件封装", required = true) @RequestBody Map searchMap,
                             @ApiParam(name = "参数", value = "页码") @PathVariable int page,
                             @ApiParam(name = "参数", value = "页码大小") @PathVariable int size) {
        Page<Brand> pageList = brandService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.SUCCESS, "查询成功", new PageResult<Brand>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-09 08:58
     * @Params: searchMap   搜索条件
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 条件查询
     */
    @PostMapping("/search")
    @ApiOperation(value = "条件查询", httpMethod = "POST")
    public Result findSearch(@ApiParam(name = "参数", value = "搜索条件" , required = true) @RequestBody Map searchMap) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", brandService.findSearch(searchMap));
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-09 09:01
     * @Params: brand     品牌对象
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 添加商品
     */
    @PostMapping
    @ApiOperation(value = "添加品牌", httpMethod = "POST")
    public Result insert(@ApiParam(name = "参数", value = "品牌对象", required = true) @RequestBody Brand brand) {
        brandService.insert(brand);
        return new Result(true, StatusCode.SUCCESS, "增加成功");
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-09 09:08
     * @Params: brand   品牌对象
     * @Params: id      品牌ID
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 修改品牌
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "修改品牌", httpMethod = "PUT")
    public Result update(@ApiParam(name = "参数", value = "品牌对象") @RequestBody Brand brand,
                         @ApiParam(name = "参数", value = "品牌ID", required = true) @PathVariable String id) {
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.SUCCESS, "修改成功");
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-09 09:15
     * @Params: id      品牌ID
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 根据ID删除品牌
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据ID删除品牌", httpMethod = "DELETE")
    public Result delete(@ApiParam(name = "参数", value = "品牌ID", required = true) @PathVariable String id) {
        brandService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

}
