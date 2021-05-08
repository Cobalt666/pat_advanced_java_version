package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test1034 {
    static int N, threshold, currentId=0, head, currentWeight, currentCnt;
    static int[] weightList;
    static boolean[] isVisited;
    static Map<Integer, String> idToNames;
    static Map<String, Integer> nameToIds;
    static int[][] matrix;
    int getId(String name){
        if(!nameToIds.containsKey(name)){
            idToNames.put(currentId, name);
            nameToIds.put(name, currentId);
            currentId++;
        }
        return nameToIds.get(name);
    }

    void dfs(int id){
        currentCnt++;
        isVisited[id]=true;
        if(weightList[id]>weightList[head]){
            head = id;
        }
        for(int i=0; i<currentId; i++){
            if(matrix[id][i]>0){
                currentWeight+=matrix[id][i];
                matrix[id][i]=0;
                matrix[i][id]=0;
                if(!isVisited[i])
                    dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        test1034 main1 = new test1034();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bufferedReader.readLine().split("\\s");
        N = Integer.parseInt(line1[0]);
        threshold = Integer.parseInt(line1[1]);
        nameToIds = new HashMap<>();
        idToNames = new HashMap<>();
        matrix = new int[2000][2000];
        weightList = new int[2000];
        for(int i=0; i<N; i++){
            String[] line = bufferedReader.readLine().split("\\s");
            int a = main1.getId(line[0]);
            int b = main1.getId(line[1]);
            int weight = Integer.parseInt(line[2]);
            matrix[a][b]+=weight;
            matrix[b][a]+=weight;
            weightList[a]+=weight;
            weightList[b]+=weight;
        }
        isVisited = new boolean[currentId];
        List<String> res = new ArrayList<>();
        for(int i=0; i<currentId; i++){
            head=i;
            currentWeight=0;
            currentCnt=0;
            main1.dfs(i);
            if(currentCnt>2&&currentWeight>threshold){
                res.add(idToNames.get(head)+" "+currentCnt);
            }
        }
        Collections.sort(res);
        System.out.println(res.size());
        for(String s: res){
            System.out.println(s);
        }
    }
}
