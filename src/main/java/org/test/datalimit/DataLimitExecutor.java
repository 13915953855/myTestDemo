package org.test.datalimit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/1
 * @Description:注解统一执行接口类
 */
@Component
public class DataLimitExecutor {

    @Autowired
    private DataLimitRegister dataLimitRegister;

    public <R, T> R execute(Class<T> targetClz, String keyType, Function<T, R> exeFunction) {
        T component = locateComponent(keyType);
        return exeFunction.apply(component);
    }

    protected <C> C locateComponent(String keyType) {
        C extension = locateExtension(keyType);
        return extension;
    }

    protected <Ext> Ext locateExtension(String keyType) {
        Ext extension = (Ext)dataLimitRegister.getDataLimitRepo().get(keyType);
        if (extension != null) {
            return extension;
        }

        throw new RuntimeException("Can not find extension with keyType:"+keyType);
    }
}
