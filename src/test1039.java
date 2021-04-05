package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test1039 {

    int getId(String str){
        return (str.charAt(0)-'A')*26*26*10+(str.charAt(1)-'A')*26*10+(str.charAt(2)-'A')*10+str.charAt(3)-'0';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = (bufferedReader.readLine()).split(" ");
        int N = Integer.parseInt(line1[0]);
        int K = Integer.parseInt(line1[1]);
        test1039 main1 = new test1039();//change

//        System.out.println(main1.getId("ZZZ9"));

        List<Integer>[] lists = new ArrayList[175760];
        for(int i=0; i<K; i++){
            String[] line = (bufferedReader.readLine()).split(" ");
            int cid = Integer.parseInt(line[0]);
            int cnum = Integer.parseInt(line[1]);
            String[] names = (bufferedReader.readLine()).split(" ");
            for(int j=0; j<cnum; j++){
                int name_id = main1.getId(names[j]);
                if(lists[name_id]==null){
                    lists[name_id] = new ArrayList<>();
                }
                lists[name_id].add(cid);
            }
        }

        String[] querys = (bufferedReader.readLine()).split(" ");
        for(int i=0; i<querys.length; i++){
            int name_id = main1.getId(querys[i]);
            if(lists[name_id]==null){
                lists[name_id] = new ArrayList<>();
            }
            System.out.printf("%s %d", querys[i], lists[name_id].size());
            Collections.sort(lists[name_id]);
            for(Integer cid: lists[name_id]){
                System.out.printf(" %d", cid);
            }
            if(i!=querys.length-1){
                System.out.printf("\n");
            }
        }
    }
}
