package org.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * @Author: 徐森
 * @CreateDate: 2018/12/25
 * @Description:
 */
public class socketConn {
    public static void main(String[] args) throws Exception {
        //客户端请求与本机在20006端口建立TCP连接
        Socket client = new Socket("127.0.0.1", 20010);
        CommL commL = new CommL(client);
        commL.setSoTimeout(10000);
        commL.sendln("{\"code\":\"31\",\"heart\":20,\"key\":0,\"user\":\"user\",\"stamp\":\"12345678910123\",\"sign\":\"9292384FA8020049949\"}", "发送内容：", true, false);//1.建立连接
        commL.readln("接受内容：", true, false);
        //建立连接时定义heart:20，即需要每20秒发送心跳包，心跳包示例：{"code":"**","key":1}
        //首次推送推送全部车位状态，示例消息：{"code":"32","data":[{"r":"1168","i":"01","c":"Y","t":"1504872000000"},{"r":"1168","i":"03","c":"N","t":"1504872000000"}],"key": 2}
        //车辆入场示例消息：{"code":"32","data":[{"r":"1168","i":"03","c":"Y","t":"1505210000000"}],"key": 3}
        //车辆出场示例消息：{"code":"32","data":[{"r":"1168","i":"03","c":"N","t":"1505210000000"}],"key": 4}
        String str = "{\"code\":\"**\",\"key\":1}";
        //发送数据到服务端
        commL.sendln(str, "发送内容：", true, false);
        try{
            //从服务器端接收数据有个时间限制（系统自设，也可以自己设置），超过了这个时间，便会抛出该异常
            String echo = commL.readln("接受内容：", true, false);
        }catch(SocketTimeoutException e){
            System.out.println("Time out, No response");
        }
        commL.close();
    }
}
