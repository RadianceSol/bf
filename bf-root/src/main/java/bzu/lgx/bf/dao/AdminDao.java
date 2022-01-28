package bzu.lgx.bf.dao;

import bzu.lgx.bf.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: LGX-LUCIFER
 * @Date: 2022-01-27 11:04
 * @Description:
 */
public interface AdminDao extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {


    @Query(value = "SELECT u FROM Admin u WHERE u.username = ?1")
    public Admin findByUsername(String username);
}
