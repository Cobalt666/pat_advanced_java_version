package pat;

import java.util.Scanner;

public class test1002 {
    public static void main(String args[]){
        double co[] = new double[1001];
        // scanner在pat里超时
        Scanner scanner = new Scanner(System.in);
        for(int j=0; j<2; j++){
            int n1 = scanner.nextInt();
            for(int i=0; i<n1; i++){
                int e = scanner.nextInt();
                double c = scanner.nextDouble();
                co[e]+=c;
            }
        }
        int cnt = 0;
        for(int i=0; i<co.length; i++){
            if(co[i]>0.0){
                cnt++;
            }
        }
        System.out.printf("%d", cnt);
        for(int i=co.length-1; i>=0; i--){
            if(co[i]>0.0){
                System.out.printf(" %d %.1f", i, co[i]);
            }
        }
    }
}
