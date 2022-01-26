package bzu.lgx.bf.service;

import bzu.lgx.bf.entity.Spec;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022/1/20 15:01
 * @Description:
 */
public interface SpecService {

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 15:02
     * @Params: spec
     * @Return: void
     * @Description: 添加规格
     */
    public void insert(Spec spec);

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 15:20
     * @Params: id
     * @Return: void
     * @Description: 根据ID删除规格
     */
    public void deleteById(String id);
}
