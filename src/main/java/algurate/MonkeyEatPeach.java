package algurate;

/**
 * @Author: 徐森
 * @CreateDate: 2019/12/31
 * @Description:
 */
public class MonkeyEatPeach {
    private static int eat(int total,int day){
        if(day == 0) return total;
        total = (total+1)*3/2;
        return eat(total,day-1);
    }
    public static void main(String[] args) {
        int a = eat(2,1);
        System.out.println(a);
    }
}
