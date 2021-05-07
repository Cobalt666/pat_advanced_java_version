package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test1013 {
    static int N;
    static int[][] matrix;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bufferedReader.readLine().split("\\s");
        N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);
        matrix = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0;i<M; i++){
            String[] line = bufferedReader.readLine().split("\\s");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            matrix[a][b]=1;
            matrix[b][a]=1;
        }
        String[] line3 = bufferedReader.readLine().split("\\s");
        test1013 main1 = new test1013();
        for(int i=0; i<line3.length; i++){
            Arrays.fill(visited, false);
            visited[Integer.parseInt(line3[i])]=true;
            int cnt = 0;
            for(int j=1;j<=N; j++){
                if(!visited[j]){
                    main1.dfs(j);
                    cnt++;
                }
            }
            System.out.println(cnt-1);
        }
    }
    void dfs(int id){
        visited[id]=true;
        for(int i=1;i<=N; i++){
            if(matrix[i][id]==1&&!visited[i]){
                dfs(i);
            }
        }
    }
}
