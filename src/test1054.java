package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class test1054 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = (bufferedReader.readLine()).split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);
        int sum = N*M;

        Map<String, Integer> cntMap = new HashMap<>();
        for(int i=0; i<M; i++){
            String[] line = (bufferedReader.readLine()).split(" ");
            for(String str: line){
                Integer cnt = cntMap.get(str);
                if(cnt==null){
                    cnt=0;
                }
                cntMap.put(str, ++cnt);
                if(cnt>sum/2){
                    System.out.println(str);
                    System.exit(1);
                }
            }
        }
    }
}
