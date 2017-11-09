package com.huarui.manager.action;

import com.huarui.manager.entity.TbItem;
import com.huarui.manager.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/11/9.
 */
@Controller
public class TbItemAction {
    @Autowired
    private TbItemService tbItemService;

    @RequestMapping("/item/testfindall")
    @ResponseBody
    public List<TbItem> testfindall(int page, int size){
        return tbItemService.testfindall(page,size);
    }
}
