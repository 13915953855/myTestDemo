package org.test.datalimit;

import lombok.Getter;
import lombok.Setter;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;

/**
 * @Author: 徐森
 * @CreateDate: 2019/8/1
 * @Description:利用Reflections进行包扫描，返回注解KeyType的实现类集合
 */
public class ClassPathScanHandler {
    /**
     * the reflections.
     */
    @Getter
    @Setter
    private Reflections reflections = null;

    public ClassPathScanHandler(String... packages){
        this.reflections = new Reflections(new ConfigurationBuilder().forPackages(packages)
        .addScanners(new TypeAnnotationsScanner(),new SubTypesScanner()));
    }

    public Set<Class<?>> getPackageAllClasses() {
        return this.reflections.getTypesAnnotatedWith(KeyType.class);
    }
}
