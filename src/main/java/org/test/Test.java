package org.test;

import org.test.linshi.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String a = "${a}用电量${a}${a}度，进行告警";
        a.replaceAll("\\$\\{a\\}","hello");
        System.out.println(a);
    }

}
