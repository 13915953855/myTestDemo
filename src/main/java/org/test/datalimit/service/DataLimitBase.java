package org.test.datalimit.service;

import com.cmiot.chinamobile.smokedetector.device.annotation.DataLimited;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/1
 * @Description: 校验数据权限父类
 */
public interface DataLimitBase {
    Boolean needDataLimit(HttpServletRequest httpServletRequest, DataLimited dataLimited);
}
