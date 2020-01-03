package algurate;

/**
 * @Author: 徐森
 * @CreateDate: 2020/1/3
 * @Description:
 */
public class BigCommonDivisor {
    public static int getBigCommonDivisor(int a,int b){
        int max = a>b?a:b;
        int min = b>a?a:b;
        int remainder = max % min;
        while(remainder > 0){
            max = min;
            min = remainder;
            remainder = max % min;
        }
        return min;
    }

    public static void main(String[] args) {
        int bigCommonDivisor = getBigCommonDivisor(28, 16);
        System.out.println(bigCommonDivisor);
    }
}
