package bzu.lgx.bf.service.impl;

import bzu.lgx.bf.dao.TemplateDao;
import bzu.lgx.bf.entity.Template;
import bzu.lgx.bf.service.TemplateService;
import bzu.lgx.bf.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-20 11:36
 * @Description:
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateDao templateDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 11:52
     * @Params: id
     * @Return: bzu.lgx.bf.entity.Template
     * @Description: 根据ID查询模板
     */
    @Override
    public Template findById(String id) {
        return templateDao.getById(id);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 11:53
     * @Params: template
     * @Return: void
     * @Description: 添加模板
     */
    @Override
    public void insert(Template template) {
        template.setId(idWorker.nextId() + "");
        template.setParaNum(0);
        template.setSpecNum(0);
        templateDao.save(template);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 16:39
     * @Params: id
     * @Return: void
     * @Description: 根据ID删除模板
     */
    @Override
    public void deleteById(String id) {
        templateDao.deleteById(id);
    }
}
