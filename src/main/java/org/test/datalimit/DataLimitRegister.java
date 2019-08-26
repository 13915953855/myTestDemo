package org.test.datalimit;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.test.datalimit.service.DataLimitBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/1
 * @Description:注册注解实现类
 */
@Component
public class DataLimitRegister implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Getter
    private Map<String, DataLimitBase> dataLimitRepo = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void doRegistration(Class<?> targetClz) {
        DataLimitBase extension = (DataLimitBase) applicationContext.getBean(targetClz);
        KeyType extensionAnn = targetClz.getDeclaredAnnotation(KeyType.class);

        dataLimitRepo.put(extensionAnn.type(), extension);
    }
}
