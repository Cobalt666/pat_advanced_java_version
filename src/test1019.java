package pat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test1019 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int b = scanner.nextInt();
        List<Integer> res = new ArrayList<>();
        while(N>0){
            res.add(N%b);
            N/=b;
        }
        boolean flag = true;
        for(int i=0; i<res.size()/2; i++){
            if(!res.get(i).equals(res.get(res.size()-i-1))){
                flag = false;
                break;
            }
        }
        if(!flag){
            Collections.reverse(res);
        }
        System.out.println(flag?"Yes":"No");
        for(int i=0; i<res.size(); i++){
            System.out.printf("%d", res.get(i));
            if(i!=res.size()-1) System.out.print(" ");
        }

    }
}
