package algurate;

import java.util.Arrays;

/**
 * @Author: 徐森
 * @CreateDate: 2020/1/3
 * @Description:
 */
public class ThreeIntsCloseTarget {
    public static int getSumClosestToTarget(int[] nums,int target){
        int close = nums[0]+nums[1]+nums[2];
        int diff = Math.abs(close - target);
        for (int i = 0; i < nums.length - 1; i++) {
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                int newDiff = Math.abs(sum-target);
                if(newDiff < diff){
                    diff = newDiff;
                    close = sum;
                }
                if(close < target) ++start;
                else --end;
            }
        }
        return close;
    }

    public static void main(String[] args) {
        int[] s = {-1,1,2,-4};
        System.out.println(getSumClosestToTarget(s,1));
    }
}
