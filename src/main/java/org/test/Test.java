package org.test;


import org.test.linshi.MD5Utils;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.println(MD5Utils.md5Bit32Lower("Hzyddl@2019"));
        //1.求和
       /* Integer sum = numbers.stream().reduce(Integer::sum).get();
        System.out.println("总和:" + sum);
        Integer min = numbers.stream().reduce(Integer::min).get();
        System.out.println("最小数:" + min);
        Integer max = numbers.stream().reduce(Integer::max).get();
        System.out.println("最大数:" + max);

        IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
        //2.转成大写
        List<String> strings = Arrays.asList("abc","hello");
        List<String> tmp = strings.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(strings);
        System.out.println(tmp);
        //3.取出所有name等于A的id

        //4.forEach
        strings.stream().filter(x->!x.equals("xusen")).forEach(x->System.out.println(x));*/
    }
}
