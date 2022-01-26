package bzu.lgx.bf.service;

import bzu.lgx.bf.entity.Category;

import java.util.List;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022/1/25 10:15
 * @Description:
 */
public interface CategoryService {

    public List<Category> findAll();

    public Category findById(String id);

    public void insert(Category category);

    public void updata(Category category);

    public void deleteById(String id);

}
