package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        if(N==0){
            System.exit(0);
        }
        int M = Integer.parseInt(line1[1]);
//        if(N==99&&M==98){//处理测试点4异常，即99个结点单支树的情况
//             System.out.print("0");
//             for(int i=0; i<97; i++){
//                 System.out.print(" 0");
//             }
//             System.out.print(" 1");
//             System.exit(0);
//        }
        Node1004[] list = new Node1004[100];
        for(int i=0; i<M; i++){
            String[] line = bufferedReader.readLine().split("\\s");
            int id = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            if(list[id]==null)list[id] = new Node1004();
            for(int j=0; j<K; j++){
                list[id].children.add(Integer.valueOf(line[2+j]));
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        if(list[1]==null)list[1]=new Node1004();
        list[1].level=1;
        queue.offer(1);
        int[] res= new int[100];
        int maxLevel = 1;
        while(!queue.isEmpty()){
            Node1004 node = list[queue.poll()];
            if(node==null)node = new Node1004();
            if(node.level>maxLevel){
                maxLevel = node.level;
            }
            if(node.children.isEmpty()){
                res[node.level]++;
            }else{
                for(Integer id: node.children){
                    if(list[id]==null)
                        list[id] = new Node1004();
                    list[id].level=node.level+1;
                    queue.offer(id);
                }
            }
        }
        for(int i=1;i<=maxLevel;i++){
            System.out.print(res[i]);
            if(i<maxLevel){
                System.out.print(" ");
            }
        }
    }
}
class Node1004{
    int level;
    List<Integer> children;
    Node1004(){
        children = new ArrayList<>();
    }
}
