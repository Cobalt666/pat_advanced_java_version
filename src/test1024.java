package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1024 {

    boolean isPalindromic(String str){
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().split(" ");
        String N = line[0];
        int K = Integer.parseInt(line[1]);
        int step = 0;
        test1024 main1 = new test1024();//change to class Main

        while(step<K){
            if(main1.isPalindromic(N))break;
            StringBuffer stringBuffer = new StringBuffer(N);
            String reverse = stringBuffer.reverse().toString();
            int curr=0, fix = 0;
            for(int i=0; i<reverse.length(); i++){
                int temp = fix+(N.charAt(reverse.length()-1-i)-'0')+(reverse.charAt(reverse.length()-1-i)-'0');
                curr = temp%10;
                fix=temp/10;
                stringBuffer.replace(reverse.length()-1-i, reverse.length()-i, curr+"");
            }
            if(fix!=0){
                stringBuffer.insert(0, fix+"");
            }
            N = stringBuffer.toString();
            step++;
        }
        System.out.println(N+"\n"+step);
    }
}
