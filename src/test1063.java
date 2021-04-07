package pat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class test1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Set<Integer>[] sets = new HashSet[N];//0 - n-1
        for(int i=0; i<N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            int M = Integer.parseInt(line[0]);
            for(int j=1; j<=M; j++){
                Integer x = Integer.valueOf(line[j]);
                if(j==1){
                    sets[i] = new HashSet<Integer>();
                }
                sets[i].add(x);
            }
        }

        int K = Integer.parseInt(bufferedReader.readLine());
        int a, b, Nc, Nt;
        for(int i=0; i<K; i++){
            String[] line = bufferedReader.readLine().split(" ");
            a = Integer.parseInt(line[0])-1;
            b = Integer.parseInt(line[1])-1;
            Nc = 0;
            Nt = sets[b].size();
            for(Integer x: sets[a]){
                if(sets[b].contains(x)){
                    Nc++;
                }else{
                    Nt++;
                }
            }

            System.out.printf("%.1f%%\n", Nt==0?0.0:(Nc*1.0/Nt)*100.0);
        }
    }
}
