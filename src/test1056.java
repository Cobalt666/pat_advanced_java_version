package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class test1056 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int G = Integer.parseInt(line1[1]);
        String[] line2 = bufferedReader.readLine().split(" ");
        int[] weights = new int[N];
        //用Java8 Stream.of转换的话会全部超时
        for(int i=0; i<N; i++){
            weights[i]=Integer.parseInt(line2[i]);
        }
        String[] line3 = bufferedReader.readLine().split(" ");

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            queue.offer(Integer.valueOf(line3[i]));
        }
        int[] ranks = new int[N];
        while(queue.size()>1){
            int queSize = queue.size();
            int groupSize = queSize/G + ((queSize%G==0)?0:1);
            int cnt = 0, maxWeight=-1, maxId=-1;

            for(int i=0; i<queSize; i++){
                if(weights[queue.peek()]>maxWeight){
                    maxId=queue.peek();
                    maxWeight = weights[maxId];
                }
                ranks[queue.peek()]=groupSize+1;
                queue.poll();
                cnt++;
                if(cnt==G||i==queSize-1){
                    cnt=0;
                    queue.offer(maxId);
                    maxId=-1;
                    maxWeight=-1;
                }
            }
        }
        ranks[queue.peek()]=1;
        for(int i=0; i<ranks.length; i++){
            System.out.print(ranks[i]);
            if(i<ranks.length-1) System.out.print(" ");
        }
    }
}
