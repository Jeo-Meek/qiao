package com.qiaoqiao.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiaoqiao.dto.ShopExecution;
import com.qiaoqiao.enums.ShopStateEnum;
import com.qiaoqiao.exceptions.ShopOperationException;
import com.qiaoqiao.pojo.Area;
import com.qiaoqiao.pojo.PersonInfo;
import com.qiaoqiao.pojo.Shop;
import com.qiaoqiao.pojo.ShopCategory;
import com.qiaoqiao.service.AreaService;
import com.qiaoqiao.service.ShopCategoryService;
import com.qiaoqiao.service.ShopService;
import com.qiaoqiao.util.CodeUtil;
import com.qiaoqiao.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getshopmanagementinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getShopManagementInfo(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        long shopId = HttpServletRequestUtil.getLong(request, "shopId");
        if (shopId <= 0) {
            Object currentShopObj = request.getSession().getAttribute("currentShop");
            if (currentShopObj == null) {
                modelMap.put("redirect", true);
                modelMap.put("url", "/shopadmin/shoplist");
            } else {
                Shop currentShop = (Shop) currentShopObj;
                modelMap.put("redirect", false);
                modelMap.put("shopId", currentShop.getShopId());
            }
        } else {
            Shop currentShop = new Shop();
            currentShop.setShopId(shopId);
            request.getSession().setAttribute("currentShop", currentShop);
            modelMap.put("shopId", shopId);
            modelMap.put("redirect", false);
        }
        return modelMap;
    }
    @RequestMapping(value = "/getshoplist", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getShopList(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
        try {
            Shop shopCondition = new Shop();
            shopCondition.setOwner(user);
            ShopExecution se = shopService.getShopList(shopCondition, 0, 100);
            modelMap.put("shopList", se.getShopList());
            // 列出店铺成功之后，将店铺放入session中作为权限验证依据，即该帐号只能操作它自己的店铺
            request.getSession().setAttribute("shopList", se.getShopList());
            modelMap.put("user", user);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }
    /**
     * 商铺注册功能
     * @param request
     * @return
     */
    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    @ResponseBody
    private Map<String ,Object> registerShop(HttpServletRequest request){
        Map<String ,Object> modelMap = new HashMap<String,Object>();
        //1.接受并转化相应的参数，包括店铺信息及图片信息
        //(1)shopStr 前端参数,将 jackson字符串 转成 shop 对象数据
        String shopStr = HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try{
            shop = mapper.readValue(shopStr,Shop.class);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
        //(2) 获取前端传过来的图片文件流
        CommonsMultipartFile shopImg = null;
        //a.解析 request 里面的文件
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext()
        );
        //b.判断是否有文件流
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        //c.将“shopImg” 前端参数 转换成 CommonsMultipartFile 类型
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }
        //2.注册店铺
        //(1)验证码的校验
        if( !CodeUtil.checkVerifyCode(request)){
            modelMap.put("success",false);
            modelMap.put("errMsg","输入了错误的验证码");
            return modelMap;
        }
        //(2)用户输入的注册信息的校验
        if(shop != null && shopImg != null){
            //a.通过 session 获取用户信息，并加入到shop 对象中
            PersonInfo owner = (PersonInfo)(request.getSession().getAttribute("user"));
            shop.setOwner(owner);
            //ShopExecution shop对象执行类，
            ShopExecution se = null;
            try {
                //将shop 对象数据添加
                se = shopService.addShop(shop,shopImg.getInputStream(),shopImg.getOriginalFilename());
                //如果添加成功，执行类的状态处于 核验中，返回ture
                if (se.getState() == ShopStateEnum.CHECK.getState()){
                    modelMap.put("success",true);
                    //该用户可以操作的店铺列表
                    List<Shop> shopList = (List<Shop>)request.getSession().getAttribute("shopList");
                    if(shopList == null || shopList.size() ==0){
                        shopList = new ArrayList<Shop>();
                    }else {
                        shopList.add(se.getShop());
                        request.getSession().setAttribute("shopList",shopList);
                    }
                }else {
                    modelMap.put("success",false);
                    modelMap.put("errMsg",se.getStateInfo());
                }
            } catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
            }catch (ShopOperationException e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
            }
            return modelMap;
        }else {//shop 和 shopImg 任一为空，都返回错误
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入店铺信息");
            return modelMap;
        }
    }

    /**
     * 通过 ID 获取 shop 信息
     * areaList 信息
     * @param request
     * @return
     */
    @RequestMapping(value = "getshopbyid",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getShopById(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Long shopId = HttpServletRequestUtil.getLong(request,"shopId");
        if(shopId > -1){
            try{
                Shop shop = shopService.getByShopId(shopId);
                List<Area> areaList = areaService.getAreaList();
                modelMap.put("shop",shop);
                modelMap.put("areaList",areaList);
                modelMap.put("success",true);
            }catch(Exception e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.toString());
            }

        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","empty shopId");
        }
        return modelMap;
    }

    /**
     * 获取 店铺分类、所属区域 option 选择列表
     * @return
     */
    @RequestMapping(value = "/getshopinitinfo",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getShopInitInfo(){
        Map<String ,Object> modelMap = new HashMap<String,Object>();
        List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
        List<Area> areaList = new ArrayList<Area>();
        try{
            shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
            areaList = areaService.getAreaList();
            modelMap.put("shopCategoryList",shopCategoryList);
            modelMap.put("areaList",areaList);
            modelMap.put("success",true);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
        return modelMap;
    }

    /**
     * 商铺编辑功能
     * @param request
     * @return
     */
    @RequestMapping(value = "/modifyshop",method = RequestMethod.POST)
    @ResponseBody
    private Map<String ,Object> modifyShop(HttpServletRequest request){
        Map<String ,Object> modelMap = new HashMap<String,Object>();
        //1.接受并转化相应的参数，包括店铺信息及图片信息
        //shopStr 前端参数
        String shopStr = HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try{
           shop = mapper.readValue(shopStr,Shop.class);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
        //获取前端传过来的图片文件流
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext()
        );
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            //shopImg 前端参数
            shopImg =
                    (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }
        //2.修改店铺信息
        if( !CodeUtil.checkVerifyCode(request)){
            modelMap.put("success",false);
            modelMap.put("errMsg","输入了错误的验证码");
            return modelMap;
        }
        if(shop != null && shop.getShopId() != null){
            PersonInfo owner = (PersonInfo)request.getSession().getAttribute("user");
            shop.setOwner(owner);
            ShopExecution se = null;
            try {
                if(shopImg == null){
                    se = shopService.modifyShop(shop,null,null);
                }else {
                    se = shopService.modifyShop(shop,shopImg.getInputStream(),shopImg.getOriginalFilename());
                }
                if (se.getState() == ShopStateEnum.SUCCESS.getState()){
                    modelMap.put("success",true);
                }else {
                    modelMap.put("success",false);
                    modelMap.put("errMsg",se.getStateInfo());
                }
            } catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
            }catch (ShopOperationException e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
            }
            return modelMap;
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入店铺ID");
            return modelMap;
        }

    }
//    private static void inputStreamToFile(InputStream ins, File file){
//        FileOutputStream os = null;
//        try{
//            os = new FileOutputStream(file);
//            int bytesReader = 0;
//            byte[] buffer = new byte[1024];
//            while ((bytesReader = ins.read(buffer)) != -1){
//                os.write(buffer,0,bytesReader);
//            }
//    }catch (Exception e){
//            throw new RuntimeException("调用inputStreamToFile 异常："+e.getMessage());
//        }finally {
//            try {
//                if(os!=null){
//                    os.close();
//                }
//                if(ins != null){
//                    ins.close();
//                }
//            }catch (IOException e){
//                throw new RuntimeException("inputStreamToFile 关闭io 异常："+e.getMessage());
//            }
//        }
//        }

}
