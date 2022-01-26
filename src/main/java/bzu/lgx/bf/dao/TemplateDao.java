package bzu.lgx.bf.dao;

import bzu.lgx.bf.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-20 11:33
 * @Description: 模板数据接口层
 */
public interface TemplateDao extends JpaRepository<Template, String>, JpaSpecificationExecutor<Template> {

}
