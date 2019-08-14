package org.test;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static List<String> getList(){
        return null;//new ArrayList<>();
    }
    public static void main(String[] args) {
        try {
            //创建Socket对象
            //Socket socket = new Socket("localhost", 8888);
            String host = "61.160.201.94";
            Socket socket = new Socket(host, 30103);

            //根据输入输出流和服务端连接
            OutputStream outputStream = socket.getOutputStream(); //获取一个输出流，向服务端发送信息
            PrintWriter printWriter = new PrintWriter(outputStream); //将输出流包装成打印流

            System.out.println(" ===准备发送=== ");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", "31");
            jsonObject.put("heart", "20");
            jsonObject.put("key", 0);
            jsonObject.put("user", "user");
            jsonObject.put("stamp", "12345678910123");
            jsonObject.put("sign", "9292384FA8020049949");
            String requst = jsonObject.toJSONString();

            //String requst = "{\"code\":\"31\",\"heart\":20,\"key\":0,\"user\":\"user\",\"stamp\":\"12345678910123\",\"sign\":\"9292384FA8020049949\"}";
            System.out.println(" ===发送=== " + requst);
            printWriter.print(requst);
            printWriter.flush();
            socket.shutdownOutput(); //关闭输出流

            String s = socket.getInetAddress().toString();
            System.out.println("当前连接的ip是："+s);

            InputStream inputStream = socket.getInputStream(); //获取一个输入流，接收服务端的信息
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream); //包装成字符流，提高效率
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader); //缓冲区
            String info = "";
            String temp = bufferedReader.readLine(); //临时变量
            /*while ((temp = bufferedReader.readLine()) != null) {
                info += temp;
                System.out.println("客户端接收服务端发送信息：" + info);
            }*/
            System.out.println("客户端接收服务端发送信息：" + temp);
            //关闭相对应的资源
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
