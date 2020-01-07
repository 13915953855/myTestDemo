package algurate;

/**
 * @Author: 徐森
 * @CreateDate: 2020/1/3
 * @Description:动态规划路径问题
 */
public class BestGlodMining {
    public static int getBestGlodMining(int w,int[] p,int[] g){
        int[][] result = new int[g.length+1][w+1];
        for (int i = 1; i <=g.length ; i++) {
            for (int j = 1; j <= w ; j++) {
                if(j<p[i-1]){
                    result[i][j] = result[i-1][j];
                }else{
                    result[i][j] = Math.max(result[i-1][j],result[i-1][j-p[i-1]]+g[i-1]);
                }
            }
        }
        return result[g.length][w];
    }
    public static int getBestGlodMiningV3(int w,int[] p,int[] g){
        int[] result = new int[w+1];
        for (int i = 1; i <=g.length ; i++) {
            for (int j = w; j >= 1; j--) {
                if(j>=p[i-1]){
                    result[j] = Math.max(result[j],result[j-p[i-1]]+g[i-1]);
                }
            }
        }
        return result[w];
    }
    public static void main(String[] args) {
        int w = 10;
        int[] p={5,5,3,4,3};
        int[] g = {400,500,200,300,350};
        System.out.println(getBestGlodMining(w,p,g));

        int a = 14;
        int s = 1;
        while(0== (a&s)){
            s<<=1;
        }
        System.out.println(s);
    }
}
