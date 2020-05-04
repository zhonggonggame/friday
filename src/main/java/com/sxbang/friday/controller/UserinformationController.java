package com.sxbang.friday.controller;

import com.sxbang.friday.base.result.PageTableRequest;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.Userinformation;
import com.sxbang.friday.service.UserinformationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userinformations")
public class UserinformationController {

    @Autowired
    private UserinformationService userinformationService;


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "修改会员信息")
    public Results  update(Userinformation userinformation) {
       return userinformationService.update(userinformation);
    }
    @GetMapping("/listPage")
    @ApiOperation(value = "列表")
    @ResponseBody
    public Results<Userinformation> list(PageTableRequest request) {
          request.countOffset();
          return userinformationService.getByPage(request.getOffset(), request.getLimit());

    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除")
    @ResponseBody
    public Results delete(Userinformation userinformation) {
        return userinformationService.delete( userinformation);
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ApiOperation(value = "搜索")
    @ResponseBody
    public Results search(Userinformation userinformation) {
        return userinformationService.search( userinformation);
    }






}
