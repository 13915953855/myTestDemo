package org.test.minitomcat;

import java.io.IOException;

/**
 * @Author: 徐森
 * @CreateDate: 2019/11/28
 * @Description:
 */
public class HelloServlet extends MyServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("get hello ....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("post hello ....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
