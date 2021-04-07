package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class test1071 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = bufferedReader.readLine().split("[^A-Za-z0-9]+");
        Map<String, Integer> map = new HashMap<>();
        for(String w: words){
            String key = w.toLowerCase();
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        String maxw = "";
        int maxn = -1;
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue()>maxn){
                maxw = entry.getKey();
                maxn = entry.getValue();
            }
        }
        System.out.println(maxw+" "+maxn);
    }
}
