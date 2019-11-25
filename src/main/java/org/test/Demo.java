package org.test;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.DigestUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;

public class Demo {
    public static void main(String[] args) {
        String key = "B20WVj7UEUkPDOYu2eghEQfP";
        String encode = encode3Des(key, "CaHsE1u!");
        String encode1 = encode3Des(key, "CF7hqp*Y");
        System.out.println("加密后的用户名：" + "DES@"+encode);
        System.out.println("加密后的密码：" + "DES@"+encode1);
        String decode = resolveDESValue(key,encode);
        System.out.println("解密："+decode);
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

    public static String resolveDESValue(String key,String value) {
        //将24位秘钥MD5加密
        byte[] keyByte = hex(key);
        //logger.info("key encoded by MD5:{}",keyByte);
        //密文Base64解编码
        byte[] src = Base64.decodeBase64(value.getBytes());
        //logger.info("value decoded by Base64:{}",src);
        try {
            String deSeDe = "DESede";
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keyByte, deSeDe);
            //解密
            Cipher c1 = Cipher.getInstance(deSeDe);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return new String(c1.doFinal(src));
        } catch (java.security.NoSuchAlgorithmException e1) {
        } catch (javax.crypto.NoSuchPaddingException e2){
        } catch (BadPaddingException e3) {
        } catch (IllegalBlockSizeException e4) {
        } catch (InvalidKeyException e5) {
        }
        return null;
    }
}
