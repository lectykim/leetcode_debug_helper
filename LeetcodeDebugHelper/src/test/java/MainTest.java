import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {



    @Test
    public void test1(){
        var input="IIIDIDDD";
        var output= "123549876";

        var expected = Solution.smallestNumber(input);
        assertEquals(output,expected);
    }

    public static class Solution{
        public static String smallestNumber(String pattern) {
            StringBuilder sb;
            String res = "";
            for(int i=1;i<=9;i++){
                sb = new StringBuilder();
                sb.append(i);
                boolean[] check = new boolean[10];
                check[i] = true;
                res = back(0,pattern.length(),sb,check,pattern,i);
                if(!res.equals("NOPE")){
                    break;
                }
            }
            return res;
        }

        public static String back(int current, int len, StringBuilder sb, boolean[] check,String pattern,int before){
            if(current == len){
                return sb.toString();
            }
            String temp = sb.toString();
            if(pattern.charAt(current) == 'I'){
                for(int i=before+1;i<=9;i++){
                    if(check[i] == true)
                        continue;
                    sb.append(i);
                    check[i] = true;
                    String ret = back(current+1,len,sb,check,pattern,i);
                    if(ret.equals("NOPE")){
                        check[i] = false;
                        sb = new StringBuilder().append(temp);
                    }else{
                        return ret;
                    }
                }
            }else{
                for(int i=before-1;i>=1;i--){
                    if(check[i] == true)
                        continue;
                    sb.append(i);
                    check[i] = true;
                    String ret = back(current+1,len,sb,check,pattern,i);
                    if(ret.equals("NOPE")){
                        check[i] = false;
                        sb = new StringBuilder().append(temp);
                    }else{
                        return ret;
                    }
                }
            }

            return "NOPE";

        }
    }
}
