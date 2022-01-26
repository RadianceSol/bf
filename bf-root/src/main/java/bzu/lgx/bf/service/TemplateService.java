package bzu.lgx.bf.service;

import bzu.lgx.bf.entity.Template;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022/1/20 11:34
 * @Description:
 */
public interface TemplateService {

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 11:51
     * @Params: id
     * @Return: bzu.lgx.bf.entity.Template
     * @Description: 根据 id查找模板
     */
    public Template findById(String id);


    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 11:36
     * @Params: template
     * @Return: void
     * @Description: 添加模板
     */
    public void insert(Template template);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 16:38
     * @Params: id
     * @Return: void
     * @Description: 根据ID删除模板
     */
    public void deleteById(String id);
}
