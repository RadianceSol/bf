package bzu.lgx.bf.service.impl;

import bzu.lgx.bf.dao.ParaDao;
import bzu.lgx.bf.dao.TemplateDao;
import bzu.lgx.bf.entity.Para;
import bzu.lgx.bf.entity.Template;
import bzu.lgx.bf.service.ParaService;
import bzu.lgx.bf.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-20 16:18
 * @Description:
 */
@Service
public class ParaServiceImpl implements ParaService {

    @Autowired
    private TemplateDao templateDao;

    @Autowired
    private ParaDao paraDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 16:23
     * @Params: para
     * @Return: void
     * @Description: 添加参数
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void insert(Para para) {
        para.setId(idWorker.nextId() + "");
        Template t = templateDao.getById(para.getTemplateId());
        t.setParaNum(t.getParaNum() + 1);
        templateDao.save(t);
        paraDao.save(para);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 16:26
     * @Params: id
     * @Return: void
     * @Description: 根据ID删除参数
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteById(String id) {
        Para p = paraDao.getById(id);
        Template t = templateDao.getById(p.getTemplateId());
        t.setParaNum(t.getParaNum() - 1);
        templateDao.save(t);
        paraDao.deleteById(id);
    }
}
