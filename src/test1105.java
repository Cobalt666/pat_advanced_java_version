package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] line2 = (bufferedReader.readLine()).split(" ");
        int[] list = new int[line2.length];
        for(int i=0; i<line2.length; i++){
            list[i] = Integer.parseInt(line2[i]);
        }
        bufferedReader.close();

        int n = (int)Math.sqrt(N);
        while(N%n!=0){
            n--;
        }
        int m = N/n;
        Arrays.sort(list);

        int[][] res = new int[m][n];
        int levels = m/2 + m%2;
        int index = list.length-1;
        for(int lv = 0; lv<levels; lv++){
            for(int j=lv; j<n-lv&&index>=0; j++){
                res[lv][j]=list[index--];
            }
            for(int i=lv+1; i<m-lv&&index>=0; i++){
                res[i][n-1-lv]=list[index--];
            }
            for(int j=n-lv-2; j>=lv&&index>=0; j--){
                res[m-lv-1][j]=list[index--];
            }
            for(int i=m-lv-2; i>lv&&index>=0; i--){
                res[i][lv]=list[index--];
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.printf("%d", res[i][j]);
                if(j!=n-1) System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
