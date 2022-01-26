package bzu.lgx.bf.service.impl;

import bzu.lgx.bf.dao.BrandDao;
import bzu.lgx.bf.entity.Brand;
import bzu.lgx.bf.service.BrandService;
import bzu.lgx.bf.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-08 16:56
 * @Description: 品牌服务实现
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private IdWorker idWorker;


    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:13
     * @Return: java.util.List<bzu.lgx.bf.entity.Brand>
     * @Description: 查询全部品牌
     */
    @Override
    public List<Brand> findAll() {
        return brandDao.findAll();
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:14
     * @Params: whereMap    查询条件封装
     * @Params: page        页码
     * @Params: size        页大小
     * @Return: org.springframework.data.domain.Page<bzu.lgx.bf.entity.Brand>
     * @Description: 分页条件搜索
     */
    @Override
    public Page<Brand> findSearch(Map whereMap, int page, int size) {
        Specification<Brand> specification = createSpecification(whereMap);
        PageRequest pageRequest = PageRequest.of(-1, size);
        return brandDao.findAll(specification, pageRequest);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:16
     * @Params: whereMap    查询条件封装
     * @Return: java.util.List<bzu.lgx.bf.entity.Brand>
     * @Description: 条件查询
     */
    @Override
    public List<Brand> findSearch(Map whereMap) {
        Specification<Brand> specification = createSpecification(whereMap);
        return brandDao.findAll(specification);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:17
     * @Params: id
     * @Return: bzu.lgx.bf.entity.Brand
     * @Description: 根据ID查询品牌
     */
    @Override
    public Brand findById(String id) {
        return brandDao.getById(id);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:18
     * @Params: brand
     * @Return: void
     * @Description: 添加品牌
     */
    @Override
    public void insert(Brand brand) {
        brand.setId(idWorker.nextId() + "");
        brandDao.save(brand);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:19
     * @Params: brand
     * @Return: void
     * @Description: 修改品牌
     */
    @Override
    public void update(Brand brand) {
        brandDao.save(brand);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:21
     * @Params: id
     * @Return: void
     * @Description: 根据ID删除品牌
     */
    @Override
    public void deleteById(String id) {
        brandDao.deleteById(id);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-08 17:25
     * @Params: searchMap
     * @Return: org.springframework.data.jpa.domain.Specification<bzu.lgx.bf.entity.Brand>
     * @Description: 动态条件构造
     */
    private Specification<Brand> createSpecification(Map searchMap) {

        return (root, query, cb) -> {
            String id = "id", name = "name", letter = "letter";
            List<Predicate> predicateList = new ArrayList<Predicate>();

            if (searchMap.get(id) != null && !"".equals(searchMap.get(id))) {
                predicateList.add(cb.like(root.get("id").as(String.class), "%" + (String) searchMap.get("id") + "%"));
            }

            if (searchMap.get(name) != null && !"".equals(searchMap.get(name))) {
                predicateList.add(cb.like(root.get("name").as(String.class), "%" + (String) searchMap.get("name") + "%"));
            }

            if (searchMap.get(letter) != null && !"".equals(searchMap.get(letter))) {
                predicateList.add(cb.like(root.get("letter").as(String.class), "%" + (String) searchMap.get("letter") + "%"));
            }

            return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

        };
    }
}
