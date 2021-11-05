package com.qiaoqiao.util;

import jdk.nashorn.internal.ir.annotations.Ignore;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 将CommonsMultipartFile 转换成 File 类
     * @param cfile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cfile){
        File file = new File(cfile.getOriginalFilename());
        try {
            cfile.transferTo(file);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }catch (IllegalStateException e){
            logger.error(e.toString());
            e.printStackTrace();
        }
        return file;
    }
    /**
     * 处理缩略图，并返回新生成图片的相对路径
     * @param
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(InputStream shopImgInpuutStream, String fileName,String targetAddr) {
        //获取文件的随即名
        String realFileName = getRandomFileName();
        //获取文件的扩展名
        String extension = getFileExtension(fileName);
        //创建输出路径
        makeDirPath(targetAddr);
        //相对路径
        String relativaAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is:" +relativaAddr);
        //相对路径+根路径
        File dest = new File(PathUtil.getImgBasePath() + relativaAddr);
        logger.debug("current completeAddr is:"+PathUtil.getImgBasePath() + relativaAddr);
        try {
            Thumbnails.of(shopImgInpuutStream)
                    .size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/shuiyin.jpg")), 0.25f)
                    .outputQuality(0.8f)
                    .toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return relativaAddr;
    }

    /**
     * 创建目标路径所涉及到的目录，即 、home/work/xiangzai/xxx.jpg
     * 那么这三个文件夹都要创建出来
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        //真正父目录
        String realFileParentPath = PathUtil.getImgBasePath() +targetAddr;
        File dirPath = new File(realFileParentPath);
        //如果目录不存在，就创建
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名(.之后的名字后缀)
     * @param
     * @return
     */
     private static String getFileExtension(String  fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟 + 五位随机数
     * @return
     */
    public static String getRandomFileName() {
        //获取随机五位数
        int rannum = r.nextInt(89999)+10000;
        String noeTimeStr = sDateFormat.format(new Date());
        return  noeTimeStr+rannum;
    }
    /**
     * 删除将要被覆盖的旧文件
     *  storePath是文件的路径还是目录的路径， 如果storePath是文件路径则删除该文件，
     * 如果storePath是目录路径则删除该目录下的所有文件
     */
    public static void deleteFileOrPath(String storePath){
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if(fileOrPath.exists()){
            if(fileOrPath.isDirectory()){
                File[] files = fileOrPath.listFiles();
                for(int i = 0;i <files.length;i++){
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }

}
