package bzu.lgx.bf.dao;

import bzu.lgx.bf.entity.Para;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022/1/20 14:49
 * @Description:
 */
public interface ParaDao extends JpaRepository<Para, String>, JpaSpecificationExecutor<Para> {

}
