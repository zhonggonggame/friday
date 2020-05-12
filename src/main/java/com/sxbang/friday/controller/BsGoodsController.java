package com.sxbang.friday.controller;

import com.sxbang.friday.base.result.PageTableRequest;
import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.model.BsGoods;
import com.sxbang.friday.service.BsGoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/bsGoodss")
public class BsGoodsController {

    @Autowired
    private BsGoodsService bsGoodsService;

    @GetMapping("/listPage")
    @ApiOperation(value = "列表")
    @ResponseBody
    public Results<BsGoods> list(PageTableRequest request) {
        request.countOffset();
        Map<String, Object> param = null;
        return bsGoodsService.getByPage(param, request.getOffset(), request.getLimit());
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除")
    @ResponseBody
    public Results delete(BsGoods bsGoods) {
        return bsGoodsService.delete( bsGoods);
    }



    /**
     * 添加页面
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "保存和修改")
    @ResponseBody
    public Results save(BsGoods bsGoods) {
        if(bsGoodsService.getById(bsGoods.getId()).getCode()==200){
           return bsGoodsService.update(bsGoods);
        }else{
        return  bsGoodsService.save(bsGoods);
        }
    }



    @ApiOperation(value = "编辑页面", notes = "跳转到菜单信息编辑页面")//描述
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.GET)
    public ModelAndView roleEdit(Model model, HttpServletRequest request, BsGoods bsGoods) {
        BsGoods newBsGoods = new BsGoods();
        if(bsGoods.getId()!=null){
            newBsGoods = bsGoodsService.getBsGoodsById(bsGoods.getId());
        }
        model.addAttribute("bsGoods",newBsGoods);
        ModelAndView modelAndView =  new ModelAndView("shopGoods/bsAddGoods");
        return modelAndView;
    }

    @ApiOperation(value = "条件查询")//描述
    @RequestMapping("/search")
    @ResponseBody
    public Results search(String name,Integer category,PageTableRequest request){
        request.countOffset();
        Map params=new HashMap();
        params.put("name",name);
        params.put("category",category);
        return  bsGoodsService.getByPage(params,request.getOffset(),request.getLimit());
    }







    /**
     * 图片上传
     * @param file
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/upload")
    public Map upload(MultipartFile file, HttpServletRequest request){

        String prefix="";
        String dateStr="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                //得到文件的原始名称，通过这个名称来获取文件 格式如 xx.jpg
                String originalName = file.getOriginalFilename();
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                Date date = new Date();
                String uuid = UUID.randomUUID()+"";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateStr = simpleDateFormat.format(date);
                String filepath = "D:\\image\\book\\" +uuid+"." + prefix;
                //创建文件存储
                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                //判断本地磁盘是否存在文件
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                //上传
                file.transferTo(files);
                Map<String,Object> map2=new HashMap<>();
                Map<String,Object> map=new HashMap<>();
                map.put("code",0);
                map.put("msg","");
                map.put("data",map2);
                map2.put("src",uuid+"." + prefix);
                return map;
            }

        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",1);
        map.put("msg","");
        return map;

    }
}
