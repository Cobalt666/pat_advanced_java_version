package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = (bufferedReader.readLine()).split(" ");
        String[] line2 = (bufferedReader.readLine()).split(" ");
        bufferedReader.close();
//        int n1 = Integer.parseInt(line1[0]);
//        int n2 = Integer.parseInt(line2[0]);

        double co[] = new double[1001];
        double res[] = new double[2001];
        for(int i=1; i<line1.length; i++){
            int e = Integer.parseInt(line1[i++]);
            double c = Double.parseDouble(line1[i]);
            co[e]+=c;
        }

        for(int i=1; i<line2.length; i++){
            int e = Integer.parseInt(line2[i++]);
            double c = Double.parseDouble(line2[i]);
            for(int j=0; j<co.length; j++){
                if(co[j]>0.0){
                    res[e+j]+=c*co[j];
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<res.length; i++){
            if(res[i]>0.0){
                cnt++;
            }
        }
        System.out.printf("%d", cnt);
        for(int i=res.length-1; i>=0; i--){
            if(res[i]>0.0){
                System.out.printf(" %d %.1f", i, res[i]);
            }
        }
    }
}
