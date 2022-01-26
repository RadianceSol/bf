package bzu.lgx.bf.dao;

import bzu.lgx.bf.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-08 16:53
 * @Description: 品牌数据接口层
 */
public interface BrandDao extends JpaRepository<Brand, String>, JpaSpecificationExecutor<Brand> {

}
