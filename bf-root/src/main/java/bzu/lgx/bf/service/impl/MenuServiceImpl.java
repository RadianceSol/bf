package bzu.lgx.bf.service.impl;

import bzu.lgx.bf.dao.MenuDao;
import bzu.lgx.bf.entity.Menu;
import bzu.lgx.bf.service.MenuService;
import bzu.lgx.bf.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-27 17:04
 * @Description:
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Map> findAllMenu() {
        List<Menu> menuList = menuDao.findAll();
        return findMenuListByParentId(menuList, "0");
    }

    private List<Map> findMenuListByParentId(List<Menu> menuList, String parentId){
        List<Map> mapList = new ArrayList<>();
        for(Menu menu:menuList){
            if(menu.getParentId().equals(parentId)){
                Map map = new HashMap();
                map.put("title",menu.getMenuName());
                map.put("path", menu.getId());
                map.put("icon",menu.getIcon());
                map.put("url",menu.getUrl());
                map.put("children", findMenuListByParentId(menuList, menu.getId()));
                mapList.add(map);
            }
        }
        return mapList;
    }
}
