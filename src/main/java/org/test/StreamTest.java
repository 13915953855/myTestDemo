package org.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 徐森
 * @CreateDate: 2019/1/28
 * @Description:
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        System.out.println(nums);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        System.out.println(squareNums);

        List<String> strs = Arrays.asList("a","b","c");
        List<String> outs = strs.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(outs);

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        List<Integer> out3 = outputStream.collect(Collectors.toList());
        System.out.println(out3);


        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        List<Integer> evens = Stream.of(sixNums).filter(n -> n%2 == 0).collect(Collectors.toList());
        Integer[] integers = Stream.of(sixNums).filter(n->n%2 ==0).toArray(Integer[]::new);
        System.out.println(evens);

        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);
// 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);
// 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);
    }
}
