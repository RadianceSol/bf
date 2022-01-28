package bzu.lgx.bf.service;

import bzu.lgx.bf.entity.Admin;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022/1/27 11:05
 * @Description:
 */
public interface AdminService {

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:08
     * @Return: java.util.List<bzu.lgx.bf.entity.Admin>
     * @Description: 查询所有管理员
     */
    public List<Admin> findAll();

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:09
     * @Params: whereMap
     * @Params: page
     * @Params: size
     * @Return: org.springframework.data.domain.Page<bzu.lgx.bf.entity.Admin>
     * @Description: 分页条件查询管理员
     */
    public Page<Admin> findSearch(Map whereMap, int page, int size);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:09
     * @Params: whereMap
     * @Return: java.util.List<bzu.lgx.bf.entity.Admin>
     * @Description: 条件查询管理员
     */
    public List<Admin> findSearch(Map whereMap);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:10
     * @Params: id
     * @Return: bzu.lgx.bf.entity.Admin
     * @Description: 根据ID查询管理员
     */
    public Admin findById(String id);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-28 20:02
     * @Params: username
     * @Return: bzu.lgx.bf.entity.Admin
     * @Description: 根据用户名查找用户
     */
    public Admin findByUsername(String username);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-28 20:03
     * @Params: username
     * @Return: java.util.Set<java.lang.String>
     * @Description: 查找用户的菜单权限标识集合
     */
    public Set<String> findPermissions(String username);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:10
     * @Params: admin
     * @Return: void
     * @Description: 添加管理员
     */
    public void insert(Admin admin);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:10
     * @Params: admin
     * @Return: void
     * @Description: 修改管理员
     */
    public void updata(Admin admin);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-27 11:10
     * @Params: id
     * @Return: void
     * @Description: 根据ID删除管理员
     */
    public void deleteById(String id);

}
