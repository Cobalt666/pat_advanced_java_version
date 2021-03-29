package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1023 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        int[] fre = new int[10];
        int[] data = new int[line.length()];
        int[] res = new int[line.length()+1];
        for(int i=0; i<line.length(); i++){
            data[i]=Integer.parseInt(line.substring(i,i+1));
            fre[data[i]]++;
        }
        int curr = 0, fix = 0;
        for(int i=data.length-1; i>=0; i--){
            int temp = data[i]*2+fix;
            curr = temp%10;
            fix = temp/10;
            fre[curr]--;
            res[i+1]=curr;//res和data数组错位1位
        }
        if(fix>0){
            fre[fix]--;
            res[0]=fix;
        }
        boolean flag = true;
        for(int i=0; i<fre.length; i++){
            if(fre[i]!=0)flag=false;
        }
        System.out.println(flag?"Yes":"No");
        for(int i=0; i<res.length; i++){
            if(i==0&&res[0]==0){
                continue;
            }
            System.out.print(res[i]);
        }
        System.out.print("\n");
    }
}
