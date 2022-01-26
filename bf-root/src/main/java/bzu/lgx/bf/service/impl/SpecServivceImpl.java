package bzu.lgx.bf.service.impl;

import bzu.lgx.bf.dao.SpecDao;
import bzu.lgx.bf.dao.TemplateDao;
import bzu.lgx.bf.entity.Spec;
import bzu.lgx.bf.entity.Template;
import bzu.lgx.bf.service.SpecService;
import bzu.lgx.bf.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-20 15:03
 * @Description:
 */
@Service
public class SpecServivceImpl implements SpecService {

    @Autowired
    private TemplateDao templateDao;

    @Autowired
    private SpecDao specDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 16:22
     * @Params: spec
     * @Return: void
     * @Description: 添加规格
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void insert(Spec spec) {
        spec.setId(idWorker.nextId() + "");
        Template t = templateDao.getById(spec.getTemplateId());
        t.setSpecNum(t.getSpecNum() + 1);
        templateDao.save(t);
        specDao.save(spec);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 16:22
     * @Params: id
     * @Return: void
     * @Description: 根据ID删除规格
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteById(String id) {
        Spec s = specDao.getById(id);
        Template t = templateDao.getById(s.getTemplateId());
        t.setSpecNum(t.getSpecNum() - 1);
        templateDao.save(t);
        specDao.deleteById(id);
    }
}
