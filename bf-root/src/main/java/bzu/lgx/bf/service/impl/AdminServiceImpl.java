package bzu.lgx.bf.service.impl;

import bzu.lgx.bf.dao.AdminDao;
import bzu.lgx.bf.entity.Admin;
import bzu.lgx.bf.service.AdminService;
import bzu.lgx.bf.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.*;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-27 11:29
 * @Description:
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private AdminDao adminDao;

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:31
     * @Return: java.util.List<bzu.lgx.bf.entity.Admin>
     * @Description: 查询全部管理员
     */
    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:32
     * @Params: whereMap    查询条件封装
     * @Params: page        页码
     * @Params: size        页大小
     * @Return: org.springframework.data.domain.Page<bzu.lgx.bf.entity.Admin>
     * @Description: 分页条件搜索
     */
    @Override
    public Page<Admin> findSearch(Map whereMap, int page, int size) {
        Specification<Admin> specification = createSpecification(whereMap);
        PageRequest pageRequest = PageRequest.of(-1, size);
        return adminDao.findAll(specification,pageRequest);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:34
     * @Params: whereMap    查询条件封装
     * @Return: java.util.List<bzu.lgx.bf.entity.Admin>
     * @Description: 条件查询
     */
    @Override
    public List<Admin> findSearch(Map whereMap) {
        Specification<Admin> specification = createSpecification(whereMap);
        return adminDao.findAll(specification);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:35
     * @Params: id
     * @Return: bzu.lgx.bf.entity.Admin
     * @Description: 根据ID查询管理员
     */
    @Override
    public Admin findById(String id) {
        return adminDao.getById(id);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminDao.findByUsername(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        Set<String> permissions = new HashSet<>();
        permissions.add("sys:user:view");
        permissions.add("sys:user:add");
        permissions.add("sys:user:edit");
        permissions.add("sys:user:delete");
        return permissions;
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:36
     * @Params: admin
     * @Return: void
     * @Description: 添加管理员
     */
    @Override
    public void insert(Admin admin) {
        admin.setId(idWorker.nextId() + "");
        adminDao.save(admin);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:37
     * @Params: admin
     * @Return: void
     * @Description: 修改管理员
     */
    @Override
    public void updata(Admin admin) {
        adminDao.save(admin);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:38
     * @Params: id
     * @Return: void
     * @Description: 根据ID删除管理员
     */
    @Override
    public void deleteById(String id) {
        adminDao.deleteById(id);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:38
     * @Params: searchMap
     * @Return: org.springframework.data.jpa.domain.Specification<bzu.lgx.bf.entity.Admin>
     * @Description: 动态条件构造
     */
    private Specification<Admin> createSpecification(Map searchMap) {

        return (root, query, cb) -> {
            String id = "id", username = "username", status = "status";
            List<Predicate> predicateList = new ArrayList<Predicate>();

            if (searchMap.get(id) != null && !"".equals(searchMap.get(id))) {
                predicateList.add(cb.like(root.get("id").as(String.class), "%" + (String) searchMap.get("id") + "%"));
            }

            if (searchMap.get(username) != null && !"".equals(searchMap.get(username))) {
                predicateList.add(cb.like(root.get("username").as(String.class), "%" + (String) searchMap.get("username") + "%"));
            }

            if (searchMap.get(status) != null && !"".equals(searchMap.get(status))) {
                predicateList.add(cb.like(root.get("status").as(String.class), "%" + (String) searchMap.get("status") + "%"));
            }

            return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

        };
    }
}
