package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1058 {

    public static void main(String[] args) throws IOException {
        long G=0, S=0, K=0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().split(" ");
        String[] A = line[0].split("\\.");
        String[] B = line[1].split("\\.");
        K = Long.parseLong(A[2]) + Long.parseLong(B[2]);
        if(K>=29){
            S ++;
            K -= 29;
        }
        S += Long.parseLong(A[1]) + Long.parseLong(B[1]);
        if(S>=17){
            G ++;
            S -= 17;
        }
        G += Long.parseLong(A[0]) + Long.parseLong(B[0]);
        System.out.println(G+"."+S+"."+K);
    }
}
