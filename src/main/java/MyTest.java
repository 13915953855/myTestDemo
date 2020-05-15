import java.util.HashSet;
import java.util.Set;

public class MyTest {
    public static void main(String[] args) {
        int abcabcbb = lengthOfLongestSubstring2("abcabcbb");
        System.out.println(abcabcbb);
    }

    public static int lengthOfLongestSubstring(String s){
        int length = 0;
        int i = 0;
        int flag = 0;
        int result = 0;
        while(i<s.length()){
            int pos = s.indexOf(s.charAt(i),flag);
            if(pos < i){
                if(length > result){
                    result = length;
                }
                if(result >=s.length() -pos -1){
                    return result;
                }
                length = i - pos - 1;
                flag = pos +1;
            }
            length++;
            i++;
        }

        return length;
    }
    public static int lengthOfLongestSubstring2(String s){
        int n = s.length();

        Set<Character> set = new HashSet<>();

        int ans = 0,i=0,j=0;
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
