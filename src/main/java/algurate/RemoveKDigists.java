package algurate;

import java.util.Stack;

/**
 * @Author: 徐森
 * @CreateDate: 2020/1/3
 * @Description: 给出一个正整数，从该整数中去掉k个数字，要求剩下的数字形成的新整数尽可能小。
 */
public class RemoveKDigists {

    public static int[] removeKDigists(int[] array,int k){
        int length = array.length - k;
        if(length <= 0) {return null;}
        int [] newArr = new int[length];
        int top = 0;
        for (int i = 0; i < array.length; i++) {
            int c = array[i];
            while(top > 0 && array[i] < newArr[top-1] && k > 0){
                top--;
                k--;
            }
            newArr[top++] = c;
        }
        return newArr;
    }

    public static void main(String[] args) {
        int [] array = {5,4,1,2,7,0,9,3,6};

        int[] ints = removeKDigists(array, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
}
