package com.huarui.manager.action;

import com.huarui.common.result.EasyUIDataGridResult;
import com.huarui.common.result.EasyUITreeNode;
import com.huarui.manager.entity.TbItem;
import com.huarui.manager.service.ItemCatService;
import com.huarui.manager.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/11/9.
 */
@Controller
public class TbItemAction {
    @Autowired
    private TbItemService tbItemService;
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult<TbItem> findall(int page, int rows){
        return tbItemService.getItemList(page,rows);
    }

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(
            @RequestParam(name="id", defaultValue="0")Long parentId) {
        //调用服务查询节点列表
        List<EasyUITreeNode> list = itemCatService.getItemCatlist(parentId);
        return list;

    }
}
