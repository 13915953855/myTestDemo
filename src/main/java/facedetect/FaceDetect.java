package facedetect;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FaceDetect {
    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    private static final String APPID = "19880271";
    private static final String APIKEY = "6ZUXVUlCOBrTmFSMY8RK2Guo";
    private static final String SECERTKEY = "0StuYVQTkfS3sD5na9GFbT63MWuhqGzO";

    /*
     * 图片转换为二进制
     *
     * @param fileName
     *            本地图片路径
     * @return
     *       图片二进制流
     * */
    public static String getImageBinary(String fileName) {
        File f = new File(fileName);
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            return Base64.encodeBase64String(bytes);
            //return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String faceDetect() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            Map<String, Object> map = new HashMap<>();
            String image = getImageBinary("D:\\timg.jpg");
            //System.out.println(image);
            map.put("image", image);
            map.put("face_field", "faceshape,facetype,age,beauty,gender");
            map.put("image_type", "BASE64");

            Gson gson = new Gson();
            String param = gson.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //String accessToken = "[调用鉴权接口获取的token]";
            String accessToken = AuthService.getAuth(APIKEY,SECERTKEY);

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FaceDetect.faceDetect();
    }
}
