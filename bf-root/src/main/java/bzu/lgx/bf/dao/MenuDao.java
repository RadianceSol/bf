package bzu.lgx.bf.dao;

import bzu.lgx.bf.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-27 16:51
 * @Description:
 */
public interface MenuDao extends JpaRepository<Menu, String>, JpaSpecificationExecutor<Menu> {

}
