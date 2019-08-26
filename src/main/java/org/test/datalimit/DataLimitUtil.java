package org.test.datalimit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.datalimit.service.DataLimitBase;

import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/1
 * @Description:工具类
 */
@Slf4j
@Component
public class DataLimitUtil {
    @Autowired
    private DataLimitExecutor dataLimitExecutor;

    private static DataLimitUtil dataLimitUtil;

    @PostConstruct
    public void init(){
        dataLimitUtil = this;
        dataLimitUtil.dataLimitExecutor = this.dataLimitExecutor;
    }

    public static Boolean needDatalimit(DataLimited dataLimited) {
        return dataLimitUtil.dataLimitExecutor.execute(DataLimitBase.class,dataLimited.keyType(), e -> e.needDataLimit(dataLimited));
    }
}
