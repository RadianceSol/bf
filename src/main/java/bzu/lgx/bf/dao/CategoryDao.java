package bzu.lgx.bf.dao;

import bzu.lgx.bf.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022/1/25 10:13
 * @Description:
 */
public interface CategoryDao extends JpaRepository<Category, String>, JpaSpecificationExecutor<Category> {

}
