package org.test;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Demo {
    public static void main(String[] args) {
        String key = "KBm32ScoWpFoaTPBm70xSAHE";
        String encode = encode3Des(key, "iotuser");
        String encode1 = encode3Des(key, "iot123");
        System.out.println("加密后的用户名：" + "DES@"+encode);
        System.out.println("加密后的密码：" + "DES@"+encode1);
    }
    private static byte[] hex(String key){
        String f = DigestUtils.md5DigestAsHex(key.getBytes());
        byte[] keys = f.getBytes();
        byte[] enk = new byte[24];
        System.arraycopy(keys, 0, enk, 0, 24);
        return enk;
    }

    /**
     * 3DES加密
     * @param key 密钥，24位
     * @param srcStr 将加密的字符串
     * @return
     *
     * lee on 2017-08-09 10:51:44
     */
    private static String encode3Des(String key,String srcStr){
        byte[] keyByte = hex(key);
        byte[] src = srcStr.getBytes();
        try {
            //生成密钥
            //SecretKey deskey = new SecretKeySpec(key.getBytes(), "DESede");
            SecretKey deskey = new SecretKeySpec(keyByte, "DESede");
            //加密
            Cipher c1 = Cipher.getInstance("DESede");
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            //byte[] aa = c1.doFinal(src);
            return Base64.encodeBase64String(c1.doFinal(src));
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }catch(javax.crypto.NoSuchPaddingException e2){
            e2.getMessage();
        }catch(Exception e3){
            e3.printStackTrace();
        }
        return null;
    }
}
