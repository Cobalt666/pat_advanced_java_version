package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class test1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            BigDecimal A = new BigDecimal(line[0]);
            BigDecimal B = new BigDecimal(line[1]);
            BigDecimal C = new BigDecimal(line[2]);
            BigDecimal sum = A.add(B);
            boolean flag = (sum.compareTo(C)>0)?true:false;
            System.out.printf("Case #%d: %s\n", i+1, flag);
        }

    }
}
