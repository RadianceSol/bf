package bzu.lgx.bf.service;

import bzu.lgx.bf.entity.Para;

/**
 * @Author: LGX-LUCIFER
 * @Date: 2022-01-20 15:03
 * @Description:
 */
public interface ParaService {

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 15:03
     * @Params: para
     * @Return: void
     * @Description: 添加参数
     */
    public void insert(Para para);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 16:19
     * @Params: id
     * @Return: void
     * @Description: 根据ID删除参数
     */
    public void deleteById(String id);
}
