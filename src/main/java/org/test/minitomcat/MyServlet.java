package org.test.minitomcat;

/**
 * @Author: 徐森
 * @CreateDate: 2019/11/28
 * @Description:
 */
public abstract class MyServlet {
    public abstract void doGet(MyRequest request,MyResponse response);
    public abstract void doPost(MyRequest request,MyResponse response);

    public void service(MyRequest request,MyResponse response){
        if(request.getMethod().equalsIgnoreCase("POST")){
            doPost(request,response);
        }else{
            doGet(request,response);
        }
    }
}
