package com.sxbang.friday.controller;

import com.sxbang.friday.base.result.PageTableRequest;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.Allkinds;
import com.sxbang.friday.service.AllkindsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/allkinds")
public class AllkindsController {

    @Autowired
    private AllkindsService allkindsService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "保存")
    @ResponseBody
    public Results save(Allkinds allkinds) {
      return  allkindsService.save(allkinds);
    }

    @GetMapping(value = "/add")
    @ApiOperation(value = "新增页面", notes = "跳转到新增信息页面")//描述
    public String addShopClass(Model model) {
        model.addAttribute("allkinds",new Allkinds());
        return "allKind/allkind-add";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "修改")
    @ResponseBody
    public Results  update(Allkinds allkinds) {
       return allkindsService.update(allkinds);
    }

    @GetMapping("/listPage")
    @ApiOperation(value = "列表")
    @ResponseBody
    public Results<Allkinds> list(PageTableRequest request, Allkinds allkinds) {
          request.countOffset();
          Map<String, Object> param = null;
          return allkindsService.getByPage(param, request.getOffset(), request.getLimit());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除")
    @ResponseBody
    public Results delete(Allkinds allkinds) {
        return allkindsService.delete( allkinds);
    }

   @ApiOperation(value = "编辑页面", notes = "跳转到菜单信息编辑页面")//描述
   @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView roleEdit(Model model, HttpServletRequest request, Allkinds allkinds) {
        Allkinds newAllkinds = new Allkinds();
        if(0 != allkinds.getId()){
            newAllkinds = allkindsService.getAllkindsById(allkinds.getId());
        }
        model.addAttribute("allkinds",newAllkinds);
        ModelAndView modelAndView =  new ModelAndView("allKind/addAllkinds");
        return modelAndView;
    }

}
