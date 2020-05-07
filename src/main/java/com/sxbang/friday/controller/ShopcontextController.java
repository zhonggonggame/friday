package com.sxbang.friday.controller;

import com.sxbang.friday.base.result.PageTableRequest;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.Shopcontext;
import com.sxbang.friday.service.ShopcontextService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shopcontexts")
public class ShopcontextController {

    @Autowired
    private ShopcontextService shopcontextService;


    @GetMapping("/listPage")
    @ApiOperation(value = "列表")
    @ResponseBody
    public Results list(PageTableRequest request, Shopcontext shopcontext) {
        request.countOffset();
        Map<String, Object> param = null;
        return shopcontextService.getByPage(param, request.getOffset(), request.getLimit());
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "修改")
    @ResponseBody
    public Results  update(Shopcontext shopcontext) {
       return shopcontextService.update(shopcontext);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除")
    @ResponseBody
    public Results delete(Shopcontext shopcontext) {
        return shopcontextService.delete( shopcontext);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ApiOperation(value = "查询")
    @ResponseBody
    public Results search(String username, String shopname,PageTableRequest request) {
        request.countOffset();
        Map<String, Object>  map=new HashMap();
        map.put("username",username);
        map.put("shopname",shopname);
        Results results=shopcontextService.search(map,request.getOffset(),request.getLimit());
        return results;
    }






    /*   @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "保存")
    @ResponseBody
    public Results save(Shopcontext shopcontext) {
      return  shopcontextService.save(shopcontext);
    }*/
 /*  @ApiOperation(value = "编辑页面", notes = "跳转到菜单信息编辑页面")//描述
   @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView roleEdit(Model model, HttpServletRequest request, Shopcontext shopcontext) {
        Shopcontext newShopcontext = new Shopcontext();
        if(0 != shopcontext.getId()){
            newShopcontext = shopcontextService.getShopcontextById(shopcontext.getId());
        }
        model.addAttribute("shopcontext",newShopcontext);
        ModelAndView modelAndView =  new ModelAndView("shopContext/addShopcontext");
        return modelAndView;
    }*/
}
