package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
//        不关BufferedReader可以省一点时间，否则会有一个测试点不通过
//        bufferedReader.close();
        int prev=0, res = 0;
        for(int i=0; i<N; i++){
            int curr = Integer.parseInt(line1[i+1]);
            if(curr<prev){
                res += 5 + 4*(prev-curr);
            }else{
                res += 5 + 6*(curr-prev);
            }
            prev = curr;
        }
        System.out.println(res);
    }
}
