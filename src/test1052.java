package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class test1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);

        Node1052[] nodeList = new Node1052[100000];
        for(int i=0; i<N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            Node1052 node = new Node1052(line[0], Integer.parseInt(line[1]), line[2]);
            nodeList[Integer.parseInt(line[0])]=node;
        }
        int cnt = 0;
        // 有无效结点，需要排除这样的结点否则会有测试点不通过
        for(String address=line1[1]; !address.equals("-1"); ){
            int now = Integer.parseInt(address);
            nodeList[now].flag = 0;
            address = nodeList[now].next;
            cnt++;
        }
        //可能没有一个有效结点
        if(cnt==0){
            System.out.println("0 -1");
            System.exit(1);
        }
        Arrays.sort(nodeList, new Comparator<Node1052>() {
            @Override
            public int compare(Node1052 o1, Node1052 o2) {
                if(o1==null&&o2==null)return 0;
                else if(o1==null)return 1;
                else if(o2==null)return -1;
                else{
                    if(o1.flag==1||o2.flag==1) {
                        if(o1.flag<o2.flag)return -1;
                        else if (o1.flag==o2.flag) return 0;
                        else return 1;
                    }
                    else if(o1.value>o2.value)return 1;
                    else if(o1.value==o2.value)return 0;
                    else return -1;
                }
            }
        });
        System.out.printf("%d %s\n",cnt,nodeList[0].add);
        for(int i=0; i<cnt-1; i++){
            System.out.printf("%s %d %s\n", nodeList[i].add, nodeList[i].value, nodeList[i+1].add);
        }
        System.out.printf("%s %d -1\n", nodeList[cnt-1].add, nodeList[cnt-1].value);
    }
}
class Node1052 {
    String add, next;
    int value, flag = 1;
    Node1052(String add, int value, String next){
        this.add = add;
        this.next= next;
        this.value = value;
    }
}
