package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test1053 {
    static int N,M,S;
    static int[] weights;
    static Node1053[] list;
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bufferedReader.readLine().split("\\s");
        String[] line2 = bufferedReader.readLine().split("\\s");
        N = Integer.parseInt(line1[0]);
        M = Integer.parseInt(line1[1]);
        S = Integer.parseInt(line1[2]);
        weights = new int[N];
        for(int i=0; i<line2.length; i++){
            weights[i] = Integer.parseInt(line2[i]);
        }
        list = new Node1053[N];

        for(int i=0; i<M; i++){
            String[] line = bufferedReader.readLine().split("\\s");
            int id = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            if(list[id]==null)list[id]=new Node1053(weights[id]);
            for(int j=0; j<K; j++){
                list[id].children.add(Integer.valueOf(line[2+j]));
            }
            Collections.sort(list[id].children, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(weights[o1]>weights[o2])return -1;
                    else if(weights[o1]==weights[o2])return 0;
                    else return 1;
                }
            });
        }//scan over

        path.add(weights[0]);
        test1053 main1 = new test1053();
        main1.dfs(0, weights[0]);

    }

    void dfs(int id, int w){
        if(list[id]==null)list[id]=new Node1053(weights[id]);
        if(w>S)return;
        else if(w==S){
            if(list[id].children.size()==0){
                for(int i=0; i<path.size(); i++){
                    System.out.print(path.get(i));
                    if(i<path.size()-1)System.out.print(" ");
                    else System.out.print("\n");
                }
            }
            return;
        }else{
            for(int i=0; i<list[id].children.size(); i++){
                int cid = list[id].children.get(i);
                path.add(weights[cid]);
                dfs(cid, w+weights[cid]);
                path.remove(path.size()-1);
            }
        }
    }
}
class Node1053 {
    int weight;
    List<Integer> children;
    Node1053(int weight){
        this.weight = weight;
        this.children = new ArrayList<>();
    }

}