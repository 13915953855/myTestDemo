package org.test.linshi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description @Date Created in 2018/10/25 14:55 @User xxf
 */
public final class MD5Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(MD5Util.class);
    /**
     * 数组长度扩展1倍
     */
    private static final int DOUBLE_LEN = 2;

    /**
     * 无符号右移4位
     */
    private static final int RIGHT_SHIFT_FOUR = 4;

    /**
     * 十六进制的16
     */
    private static final int OXF = 0xF;

    private MD5Util() {
    }

    public static String encrypt(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = value.getBytes("utf-8");
            String md5 = "MD5";
            MessageDigest mdTemp = MessageDigest.getInstance(md5);
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * DOUBLE_LEN];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[(k++)] = hexDigits[(byte0 >>> RIGHT_SHIFT_FOUR & OXF)];
                str[(k++)] = hexDigits[(byte0 & OXF)];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            LOGGER.error("there is a exception:" + e);
            return null;
        }
    }
}
