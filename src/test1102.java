package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test1102 {
    static int N, cnt=0;
    static boolean[] notRoot;
    static Node1102[] list;
    static int[] inList;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        list = new Node1102[N];
        notRoot = new boolean[N];
        inList = new int[N];
        test1102 main1 = new test1102();
        for(int i=0; i<N; i++){
            String[] line = bufferedReader.readLine().split("\\s");
            int l = main1.getId(line[1]);
            int r = main1.getId(line[0]);
            list[i]= new Node1102(i, l, r);
        }
        int root=-1;
        for(int i=0; i<N; i++){
            if(!notRoot[i]){
                root=i;
                break;
            }
        }
        main1.inOrder(root, 1);
        Arrays.sort(list);
        for(int i=0; i<N; i++){
            System.out.print(list[i].id);
            if(i<N-1)System.out.print(" ");
        }
        System.out.println();
        for(int i=0; i<N; i++){
            System.out.print(inList[i]);
            if(i<N-1)System.out.print(" ");
        }
    }

    int getId(String str){
        if(str.equals("-")){
            return -1;
        }else{
            int x = Integer.parseInt(str);
            notRoot[x]=true;
            return x;
        }
    }

    void inOrder(int id, int index){
        if(id==-1)return;
        inOrder(list[id].lchild, index*2);
        list[id].index=index;
        inList[cnt++]=id;
        inOrder(list[id].rchild, index*2+1);
    }

}
class Node1102 implements Comparable<Node1102>{
    int id, lchild, rchild, index;
    Node1102(int id, int l, int r){
        this.id = id;
        this.lchild = l;
        this.rchild = r;
    }

    @Override
    public int compareTo(Node1102 o) {
        if(this.index<o.index)return -1;
        return 1;
    }
}
