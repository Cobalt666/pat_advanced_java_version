package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1046 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = (bufferedReader.readLine()).split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(bufferedReader.readLine());
        int[] sumList = new int[N+1];
        for(int i=1; i<=N; i++){
            sumList[i] = sumList[i-1]+Integer.parseInt(line1[i]);
        }
        for(int i=0; i<M; i++){
            String[] line = (bufferedReader.readLine()).split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            if(y<x){
                int temp=x;
                x=y;
                y=temp;
            }
            int len = sumList[y-1]-sumList[x-1];
            if(len>(sumList[N]-len)){
                len = sumList[N]-len;
            }
            System.out.println(len);
        }
        bufferedReader.close();
    }
}
