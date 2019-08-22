package org.test.datalimit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/1
 * @Description:扫描注解加载到上下文，并将注解实现类注册到repo中。
 */
public class DataLimitBootStrap {
    @Getter
    @Setter
    private List<String> packages;

    @Autowired
    private DataLimitRegister dataLimitRegister;

    public void init(){
        Set<Class<?>> classSet = scanConfiguredPackages();
        registerBeans(classSet);
    }

    private void registerBeans(Set<Class<?>> classSet) {
        for (Class<?> targetClz : classSet) {
            KeyType extensionAnn = targetClz.getDeclaredAnnotation(KeyType.class);
            if (extensionAnn != null) {
                dataLimitRegister.doRegistration(targetClz);
            }
        }
    }

    private Set<Class<?>> scanConfiguredPackages(){
        if(packages == null) {
            throw new RuntimeException("Packages is not present");
        }

        String[] pkgs = new String[packages.size()];

        ClassPathScanHandler handler = new ClassPathScanHandler(packages.toArray(pkgs));

        Set<Class<?>> classSet = new HashSet<>();
        classSet.addAll(handler.getPackageAllClasses());
        return classSet;
    }
}
