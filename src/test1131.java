package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test1131 {
    static Map<Integer, Integer> lineMap;
    static boolean[] isVisited;
    static List<Integer> currentList, resList;
    static List<Integer>[] adjList;
    static int minStops, minTransfers;

    void dfs(int id, int dest){
        if(id==dest){
            if(currentList.size()<=minStops){
                int trans = 0;
                for(int i=2; i<currentList.size(); i++){
                    int pre= currentList.get(i-1)*10000+currentList.get(i-2);
                    int curr = currentList.get(i)*10000+currentList.get(i-1);
                    if(!lineMap.get(pre).equals(lineMap.get(curr)))trans++;
                }
                if(currentList.size()<minStops||(currentList.size()==minStops&&trans<minTransfers)){
                    resList.clear();
                    resList.addAll(currentList);
                    minTransfers = trans;
                    minStops = currentList.size();
                }
            }
            return;
        }else{
            for(Integer nextId: adjList[id]){
                if(!isVisited[nextId]){
                    //choose
                    boolean changed = false;
                    isVisited[nextId]=true;
                    currentList.add(nextId);
                    dfs(nextId, dest);
                    //not choose
                    isVisited[nextId]=false;
                    currentList.remove(currentList.size()-1);
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        isVisited = new boolean[10000];
        currentList= new ArrayList<>();
        resList = new ArrayList<>();
        adjList = (ArrayList<Integer>[])new ArrayList[10000];
        lineMap = new HashMap<>();
        for(int i=0; i<N; i++){
            String line[]= bufferedReader.readLine().split("\\s");
            int M = Integer.parseInt(line[0]);
            int pre = Integer.parseInt(line[1]);
            for(int j=0; j<M-1; j++){
                int node = Integer.parseInt(line[2+j]);
                lineMap.put(node*10000+pre, i+1);
                lineMap.put(pre*10000+node, i+1);
                if(adjList[node]==null){
                    adjList[node]=new ArrayList<Integer>();
                }
                if(adjList[pre]==null){
                    adjList[pre]=new ArrayList<Integer>();
                }
                adjList[pre].add(node);
                adjList[node].add(pre);
                pre = node;
            }
        }
        int K = Integer.parseInt(bufferedReader.readLine());
        test1131 main1 = new test1131();
        for(int i=0; i<K; i++){
            String[] line2 = bufferedReader.readLine().split("\\s");
            int a = Integer.parseInt(line2[0]);
            int b = Integer.parseInt(line2[1]);
            minTransfers = 10000;
            minStops = 10000;
            isVisited[a]=true;
            currentList.clear();
            currentList.add(a);
            resList.clear();
            main1.dfs(a, b);
            isVisited[a]=false;
            System.out.println(minStops-1);
            for(int j=2; j<resList.size(); j++){
                int pre= resList.get(j-1)*10000+resList.get(j-2);
                int curr = resList.get(j)*10000+resList.get(j-1);
                if(!lineMap.get(pre).equals(lineMap.get(curr))){
                    System.out.printf("Take Line#%d from %04d to %04d.\n", lineMap.get(pre), a, resList.get(j-1));
                    a = resList.get(j-1);
                }
            }
            int lineId = resList.get(minStops-1)*10000+resList.get(minStops-2);
            System.out.printf("Take Line#%d from %04d to %04d.\n", lineMap.get(lineId), a, b);
        }
    }
}
