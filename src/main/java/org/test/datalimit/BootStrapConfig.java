package org.test.datalimit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/1
 * @Description:启动类
 */
@Configuration
public class BootStrapConfig {
    @Bean(initMethod = "init")
    public DataLimitBootStrap bootstrap() {
        DataLimitBootStrap bootstrap = new DataLimitBootStrap();
        List<String> packagesToScan  = new ArrayList<>();
        packagesToScan.add("com.cmiot.chinamobile.smokedetector.device.datalimit.service");
        bootstrap.setPackages(packagesToScan);
        return bootstrap;
    }
}
