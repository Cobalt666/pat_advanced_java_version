package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test1047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = (bufferedReader.readLine()).split(" ");
        int N = Integer.parseInt(line1[0]);
        int K = Integer.parseInt(line1[1]);
        String[] names = new String[N];//name_id: 0 - N-1
        List<Integer>[] lists = new ArrayList[K+1];//course_id: 1 - K

        for(int i=0; i<N; i++){
            String[] line = (bufferedReader.readLine()).split(" ");
            names[i]=line[0];
            int c = Integer.parseInt(line[1]);
            for(int j=0;j<c;j++){
                int cid = Integer.parseInt(line[2+j]);
                if(lists[cid]==null){
                    lists[cid] = new ArrayList<Integer>();
                }
                lists[cid].add(i);
            }
        }

        for(int cid=1; cid<=K; cid++){
            if(lists[cid]==null){
                lists[cid] = new ArrayList<Integer>();
            }
            System.out.println(cid+" "+lists[cid].size());
            Collections.sort(lists[cid], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return names[o1].compareTo(names[o2]);
                }
            });
            for(Integer sid: lists[cid]){
                System.out.println(names[sid]);
            }
        }
    }
}
