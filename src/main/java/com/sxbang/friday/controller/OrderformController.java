package com.sxbang.friday.controller;

import com.sxbang.friday.base.result.PageTableRequest;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dto.OrderFormVO;
import com.sxbang.friday.service.OrderformService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/orderforms")
public class OrderformController {

    @Autowired
    private OrderformService orderformService;

    @GetMapping("/listPage")
    @ApiOperation(value = "列表")
    @ResponseBody
    public Results<OrderFormVO> list(PageTableRequest request) {
        request.countOffset();
        Map<String, Object> param  = null;
        return orderformService.getByPage(param, request.getOffset(), request.getLimit());
    }

    @RequestMapping("/search")
    @ApiOperation(value = "列表")
    @ResponseBody
    public Results<OrderFormVO> search(PageTableRequest request, OrderFormVO orderFormVO) {
        request.countOffset();
        Map<String, Object> param =new HashMap<>();
        param.put("orderNum",orderFormVO.getOrderNum());
        param.put("receiver",orderFormVO.getReceiver());
        param.put("createDate",orderFormVO.getCreateDate());
        param.put("orderStatus",orderFormVO.getOrderStatus());
        param.put("status",orderFormVO.getStatus());
        return orderformService.getByPage(param, request.getOffset(), request.getLimit());
    }


    @ApiOperation(value = "编辑页面", notes = "跳转到菜单信息编辑页面")//描述
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView roleEdit(String orderNum) {
        OrderFormVO orderFormVO = orderformService.getOrderformById(orderNum);
        ModelAndView modelAndView =  new ModelAndView("orderForm/addOrderform");
        modelAndView.addObject("orderform",orderFormVO);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "修改")
    @ResponseBody
    public Results  update(OrderFormVO orderFormVO) {
        return orderformService.update(orderFormVO);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除")
    @ResponseBody
    public Results delete(OrderFormVO orderFormVO) {
        return orderformService.delete(orderFormVO);
    }



        }
