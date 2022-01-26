package bzu.lgx.bf.controller;

import bzu.lgx.bf.commons.Result;
import bzu.lgx.bf.commons.StatusCode;
import com.aliyun.oss.OSS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Author: LGX-LUCIFER
 * @Data: 2022-01-18 19:23
 * @Description: 上传图片控制层
 */
@RestController
@RequestMapping("/upload")
@Api("About Upload API")
public class UploadController {

    @Autowired
    public OSS ossClient;

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-20 10:01
     * @Params: file
     * @Return: bzu.lgx.bf.commons.Result
     * @Description: 上传文件到阿里云OSS存储
     */
    @PostMapping("/oss")
    @ApiOperation(value = "上传文件到阿里云OSS存储", httpMethod = "POST")
    public Result uploadImg(@ApiParam(name = "参数", value = "文件", required = true) @RequestParam("file") MultipartFile file) throws IOException {
        //获取文件后缀名
        //String originalFilename = file.getOriginalFilename();
        //int i = originalFilename.lastIndexOf(".");
        //String png = originalFilename.substring(i);

        //存储空间的名字
        String bucketName = "lgx-bf";
        //生成新的文件名 brand/：在bucketName里面创建的分组
        String fileName = "test/"+ file.getOriginalFilename();
        // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（fileName）。
        ossClient.putObject(bucketName, fileName, file.getInputStream());
        //文件访问地址。
        String url = "https://" + bucketName + ".oss-cn-beijing.aliyuncs.com" + "/" + fileName;
        // 关闭OSSClient。
        ossClient.shutdown();
        return new Result(true, StatusCode.SUCCESS, url);
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-18 20:36
     * @Params: file
     * @Return: java.lang.String
     * @Description: 上传图片到本地
     */
    @ResponseBody
    @PostMapping("/local")
    @ApiOperation(value = "上传图片到本地", httpMethod = "POST")
    public Result fileUpload(@ApiParam(name = "参数", value = "JPG图片", required = true) @RequestParam("file") MultipartFile file) {
        try {
            // 文件是否为空
            if (file.isEmpty()) {
                return new Result(false, StatusCode.ERROR, "文件为空");
            }
            // 文件是否是图片
            BufferedImage bi = ImageIO.read(file.getInputStream());
            if (bi == null) {
                return new Result(false, StatusCode.ERROR, "文件不是图片");
            }
            // 文件是否是JPG格式
            byte [] b = new byte[4];
            ImageInputStream iis = ImageIO.createImageInputStream(file.getInputStream());
            iis.read(b, 0, b.length);
            String type = bytesToHexString(b).toUpperCase();
            if (!type.contains("FFD8FF")) {
                iis.close();
                return new Result(false, StatusCode.ERROR, "文件不是JPG格式");
            }
            iis.close();
            //---

            String fileName = file.getOriginalFilename();

            // 文件路径
            String path = "F:/Pics";
            // 文件 路径+名称
            File dest = new File(path + "/" + fileName);

            // TODO: 将dest保存到数据库的文件path位置 绝对路径

            // 判断文件父目录是否存在
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            // 保存文件
            file.transferTo(dest);

            return new Result(true, StatusCode.SUCCESS, dest.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, StatusCode.ERROR, "上传错误");
        }
    }

    /**
     * @Author: LGX-LUCIFER
     * @Date: 2022-01-18 20:36
     * @Params: src
     * @Return: java.lang.String
     * @Description: 使用十六进制检测是否是JPG图片
     */
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

}
