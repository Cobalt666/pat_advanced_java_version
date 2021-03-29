package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1015 {
    boolean isPrime(int x){
        int sq = (int)Math.sqrt(x);
        if(x>=2){
            for(int i=2; i<=sq; i++){
                if(x%i==0){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }

    int getReverseDecimal(int x, int r){
        int res = 0;
        do{
            res = res * r + x % r;
            x /= r;
        }while(x>0);
        return res;
    }

    public static void main(String[] args) throws IOException {
        test1015 main1 = new test1015();//提交时改成Main类
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] line = (bufferedReader.readLine()).split(" ");
            if(line.length==1)break;

            int x = Integer.parseInt(line[0]);
            int r = Integer.parseInt(line[1]);

            if(main1.isPrime(x)&&main1.isPrime(main1.getReverseDecimal(x, r))){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }

    }
}
