package algurate;

/**
 * @Author: 徐森
 * @CreateDate: 2019/12/31
 * @Description:
 */
public class Hanoi {
    static int m = 0;

    public static void move(int disks, char N,char M){
        System.out.println("第" + (++m) + " 次移动 : " + " 把 " + disks + " 号圆盘从 " + N + " ->移到->  " + M);
    }

    public static void hanoi(int n,char A,char B,char C){
        if(n == 1) Hanoi.move(1,A,C);
        else {
            hanoi(n - 1, A, C, B);
            Hanoi.move(n, A, C);
            hanoi(n - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        hanoi(2,'A','B','C');
    }
}
