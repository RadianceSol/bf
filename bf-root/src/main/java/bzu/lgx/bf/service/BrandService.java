package bzu.lgx.bf.service;

import bzu.lgx.bf.entity.Brand;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022/1/8 16:56
 * @Description: 品牌服务层
 */
public interface BrandService {

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:06
     * @Return: java.util.List<bzu.lgx.bf.entity.Brand>
     * @Description: 查询全部品牌
     */
    public List<Brand> findAll();

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:08
     * @Params: whereMap
     * @Params: page
     * @Params: size
     * @Return: org.springframework.data.domain.Page<bzu.lgx.bf.entity.Brand>
     * @Description: 分页条件搜索品牌
     */
    public Page<Brand> findSearch(Map whereMap, int page, int size);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:09
     * @Params: whereMap
     * @Return: java.util.List<bzu.lgx.bf.entity.Brand>
     * @Description: 条件搜索
     */
    public List<Brand> findSearch(Map whereMap);

    /***
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:10
     * @Params: id
     * @Return: bzu.lgx.bf.entity.Brand
     * @Description: 根据ID查找品牌
     */
    public Brand findById(String id);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:11
     * @Params: brand
     * @Return: void
     * @Description: 添加品牌
     */
    public void insert(Brand brand);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:11
     * @Params: brand
     * @Return: void
     * @Description: 修改品牌
     */
    public void update(Brand brand);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:12
     * @Params: id
     * @Return: void
     * @Description: 根据ID删除品牌
     */
    public void deleteById(String id);
}
