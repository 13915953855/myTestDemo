package org.test.minitomcat;

import lombok.Data;

/**
 * @Author: 徐森
 * @CreateDate: 2019/11/28
 * @Description:
 */
@Data
public class ServletMapping {

    private String servletName;
    private String url;
    private String clazz;

    public ServletMapping(String servletName, String url, String clazz) {
        this.servletName = servletName;
        this.url = url;
        this.clazz = clazz;
    }

}
