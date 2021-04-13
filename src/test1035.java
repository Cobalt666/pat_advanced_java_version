package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1035 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int index = 0;
        boolean flag;
        String[] res = new String[N];
        for(int i=0; i<N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            StringBuilder stringBuilder = new StringBuilder(line[1]);
            flag = false;
            for(int j=0; j<stringBuilder.length(); j++){
                switch (stringBuilder.charAt(j)){
                    case '1':
                        flag = true;
                        stringBuilder.replace(j,j+1, "@");
                        break;
                    case '0':
                        flag = true;
                        stringBuilder.replace(j,j+1, "%");
                        break;
                    case 'l':
                        flag = true;
                        stringBuilder.replace(j,j+1, "L");
                        break;
                    case 'O':
                        flag = true;
                        stringBuilder.replace(j,j+1, "o");
                        break;
                }
            }
            if(flag){
                res[index++] = line[0]+" "+stringBuilder.toString();
            }
        }

        if(index!=0){
            System.out.println(index);
            for(int i=0; i<index; i++){
                System.out.println(res[i]);
            }
        }else{
            if(N==1){
                System.out.println("There is 1 account and no account is modified");
            }else{
                System.out.println("There are "+N+" accounts and no account is modified");
            }
        }

    }
}
