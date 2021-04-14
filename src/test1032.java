package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = (bufferedReader.readLine()).split(" ");
        int N = Integer.parseInt(line1[2]);
        Node1032[] nodeList = new Node1032[100000];
        int address;
        for(int i=0; i<N; i++){
            String[] line = (bufferedReader.readLine()).split(" ");
            address = Integer.parseInt(line[0]);
            Node1032 n = new Node1032(Integer.parseInt(line[2]));
            nodeList[address] = n;
        }
        address = Integer.parseInt(line1[0]);
        while(address!=-1){
            nodeList[address].flag = true;
            address = nodeList[address].next;
        }
        address = Integer.parseInt(line1[1]);
        while(address!=-1){
            if(nodeList[address].flag){
                System.out.printf("%05d\n", address);
                System.exit(1);
            }
            address = nodeList[address].next;
        }
        System.out.println(-1);
    }
}
class Node1032 {
    int next;
    boolean flag = false;
    Node1032(int next){
        this.next = next;
    }
}
