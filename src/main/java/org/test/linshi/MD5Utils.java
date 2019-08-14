package org.test.linshi;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * @Description
 * @Date Created in 2018/6/25 14:26
 * @User Administrator
 */
@Slf4j
public class MD5Utils {

    private MD5Utils() {
    }

    private static final String ALGORITHM_MD5 = "MD5";

    private static final String UTF_8 = "UTF-8";


    /**
     * MD5 32bit 小写.
     *
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     */
    public static String md5Bit32Lower(String readyEncryptStr) {
        try {
            if (Objects.nonNull(readyEncryptStr)) {
                MessageDigest md = MessageDigest.getInstance(ALGORITHM_MD5);
                md.update(readyEncryptStr.getBytes(UTF_8));
                byte[] b = md.digest();
                StringBuilder su = new StringBuilder();
                for (int offset = 0, bLen = b.length; offset < bLen; offset++) {
                    String haxHex = Integer.toHexString(b[offset] & 0xFF);
                    if (haxHex.length() < 2) {
                        su.append("0");
                    }
                    su.append(haxHex);
                }
                return su.toString();
            } else {
                return null;
            }
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
        }
        return null;
    }


    public static String SHA1(String str) {
        try {
            //指定sha1算法
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            //获取字节数组
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString().toLowerCase();

        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
