package org.test.minitomcat;

import java.util.ArrayList;
import java.util.List;
import org.test.minitomcat.FindGirlServlet;
import org.test.minitomcat.HelloServlet;
/**
 * @Author: 徐森
 * @CreateDate: 2019/11/28
 * @Description:
 */
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static{
        servletMappingList.add(new ServletMapping("findGirl","/girl","org.test.minitomcat.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("hello","/hello","org.test.minitomcat.HelloServlet"));
    }
}
