package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class test1014 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);
        int K = Integer.parseInt(line1[2]);
        int Q = Integer.parseInt(line1[3]);
        // processing times:
        String[] line2 = bufferedReader.readLine().split(" ");
        Node1014[] queueList = new Node1014[N];
        int[] res = new int[K];//和用户id错位对应
        int index = 0;
        for(int i=0; i<M&&index<K; i++){
            for(int j=0; j<N&&index<K; j++){
                int processTime = Integer.parseInt(line2[index]);
                if(queueList[j]==null){
                    queueList[j]=new Node1014();
                    queueList[j].poptime += processTime;
                }
                res[index]=(queueList[j].endtime>=17*60)?(-1):(queueList[j].endtime+processTime);
                queueList[j].endtime += processTime;
                queueList[j].offer(processTime);
                index++;
            }
        }
        int min, minId;
        Node1014 queue;
        while(index<K){
            minId = 0;
            min = queueList[minId].poptime;
            for(int i=1; i<N; i++){
                if(queueList[i].poptime<min){
                    minId=i;
                    min=queueList[i].poptime;
                }
            }
            //pop
            queue = queueList[minId];
            queue.poll();
            queue.poptime += queue.peek();

            //push
            int processTime = Integer.parseInt(line2[index]);
            res[index]=(queue.endtime>=17*60)?(-1):(queue.endtime+processTime);
            queue.endtime+=processTime;
            queue.offer(processTime);

            index++;
        }
        String[] line3 = bufferedReader.readLine().split(" ");
        for(int i=0; i<Q; i++){
            int id = Integer.parseInt(line3[i])-1;
            if(res[id]==-1){
                System.out.println("Sorry");
            }else{
                System.out.printf("%02d:%02d\n", res[id]/60, res[id]%60);
            }
        }
    }
}
class Node1014 {
    int poptime=8*60, endtime=8*60;
    private Queue<Integer> list;//processTime List

    Node1014(){
        this.list = new LinkedList<>();
    }

    public Integer peek(){
        return list.peek();
    }

    public Integer poll(){
        return list.poll();
    }

    public boolean offer(Integer e){
        return list.offer(e);
    }

}