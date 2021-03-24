package pat;

import java.util.Scanner;

public class test1031 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int N = str.length();
        int n1=-1, n2 = 3;
        while(n2<=N){
            if((N+2-n2)%2==0&&(N+2-n2)/2<=n2){
                n1 = (N+2-n2)/2;
                break;
            }
            n2++;
        }
        for(int i=0; i<n1-1; i++){
            System.out.print(str.charAt(i));
            for(int j=0; j<n2-2; j++){
                System.out.print(" ");
            }
            System.out.print(str.charAt(N-i-1)+"\n");
        }
        System.out.println(str.substring(n1-1, n1-1+n2));
    }
}
