package org.test.minitomcat;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: 徐森
 * @CreateDate: 2019/11/28
 * @Description:
 */
@Data
public class MyRequest {
    private String url;
    private String method;

    public MyRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if((length = inputStream.read(httpRequestBytes)) > 0){
            httpRequest = new String(httpRequestBytes,0,length);
        }

        String httpHead = httpRequest.split("\n")[0];
        url = httpRequest.split("\\s")[1];
        method = httpRequest.split("\\s")[0];
        System.out.println(this);
    }
}
