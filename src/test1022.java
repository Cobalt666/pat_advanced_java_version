package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class test1022 {
    void addPair(Map<String, Set<Integer>> mp, String key, Integer id){
        if(mp.containsKey(key)){
            mp.get(key).add(id);
        }else{
            Set<Integer> set = new TreeSet<>();
            set.add(id);
            mp.put(key, set);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = (bufferedReader.readLine());
        int N = Integer.parseInt(line1);
        Map<String, Set<Integer>> titleMap = new HashMap<>();
        Map<String, Set<Integer>> authorMap = new HashMap<>();
        Map<String, Set<Integer>> kwMap = new HashMap<>();
        Map<String, Set<Integer>> pubMap = new HashMap<>();
        Map<String, Set<Integer>> yearMap = new HashMap<>();
        test1022 main1 = new test1022();//change to class Main

        for(int i=0; i<N; i++){
            Integer id  = Integer.valueOf(bufferedReader.readLine());
            String title = bufferedReader.readLine();
            String author = bufferedReader.readLine();
            String[] keywords = bufferedReader.readLine().split(" ");
            String publisher = bufferedReader.readLine();
            String year = bufferedReader.readLine();

            main1.addPair(titleMap, title, id);
            main1.addPair(authorMap, author, id);
            for(String s: keywords){
                main1.addPair(kwMap, s, id);
            }
            main1.addPair(pubMap, publisher, id);
            main1.addPair(yearMap, year, id);
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        Map<String, Set<Integer>> temp = new HashMap<>();
        for(int i=0; i<M; i++){
            String line = bufferedReader.readLine();
            int type = Integer.parseInt(line.substring(0,1));
            String query = line.substring(3);
            switch (type){
                case 1:
                    temp = titleMap;
                    break;
                case 2:
                    temp = authorMap;
                    break;
                case 3:
                    temp = kwMap;
                    break;
                case 4:
                    temp = pubMap;
                    break;
                case 5:
                    temp = yearMap;
                    break;
            }
            System.out.println(line);
            if(!temp.containsKey(query)||temp.get(query).isEmpty()){
                System.out.println("Not Found");
            }else{
                for(Integer id: temp.get(query)){
                    System.out.printf("%07d\n", id);
                }
            }
        }
    }
}
