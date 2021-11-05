package com.qiaoqiao.util;

import java.util.Locale;

public class PathUtil {
    //获取文件的分隔符
    private static String seperator = System.getProperty("file.separator");

    /**
     * 返回项目图片保存的根路径
     * 获得将要被加水印图片的路径
     * @return
     */
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "F:/images/item/shop";
        }else {
            basePath = "home/xiangzai/image";
        }
        basePath = basePath.replace("/",seperator);
        return basePath;
    }

    /**
     * 返回项目图片的子路径
     * 相对子路径，获取店铺id 对应的图片路径
     * @param shopId
     * @return
     */
    public static String getShopImagePath(Long shopId){
         String imagePath = "/"+shopId+"/";
         return imagePath.replace("/",seperator);
    }
}
