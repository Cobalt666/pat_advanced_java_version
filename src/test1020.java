package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test1020 {
    List<Node1020> res = new ArrayList<>();
    static String[] postList, inList;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        postList = bufferedReader.readLine().split("\\s");
        inList = bufferedReader.readLine().split("\\s");
        test1020 main1 = new test1020();
        main1.level(1, 0, N-1, 0, N-1);
        main1.print();
    }
    //[L, R]
    void level(int index, int postLeft, int postRight, int inLeft, int inRight){
        if(postLeft>postRight){
            return;
        }
        Node1020 rootNode = new Node1020(postList[postRight], index);
        res.add(rootNode);
        int cnt=0;//size of left children
        for(int i=inLeft;i<=inRight;i++){
            if(postList[postRight].equals(inList[i]))break;
            cnt++;
        }
        level(index*2, postLeft,  postLeft + cnt -1, inLeft, inLeft+cnt-1);
        level(index*2+1, postLeft + cnt, postRight-1, inLeft+cnt+1, inRight);
    }

    void print(){
        Collections.sort(res);
        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i).value);
            if(i<res.size()-1) System.out.print(" ");
        }

    }
}
class Node1020 implements Comparable<Node1020>{
    int order;
    String value;
    Node1020(String value, int order){
        this.order = order;
        this.value = value;
    }

    @Override
    public int compareTo(Node1020 o) {
        if(this.order<o.order){
            return -1;
        }else{
            return 1;
        }
    }
}