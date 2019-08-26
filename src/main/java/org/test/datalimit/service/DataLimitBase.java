package org.test.datalimit.service;

import org.test.datalimit.DataLimited;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/1
 * @Description: 校验数据权限父类
 */
public interface DataLimitBase {
    Boolean needDataLimit(DataLimited dataLimited);
}
