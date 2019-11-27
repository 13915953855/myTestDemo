package org.test;

/**
 * @Author: 徐森
 * @CreateDate: 2019/11/26
 * @Description:
 */
public class CommonUtils {
    /**
     * 校验手机格式
     * @param mobile
     * @return
     */
    public static boolean validatePhone(String mobile) {
        return mobile.matches("^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$");
    }
}
