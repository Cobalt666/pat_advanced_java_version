package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test1017 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = (bufferedReader.readLine()).split(" ");
        int N = Integer.parseInt(line1[0]);
        int K = Integer.parseInt(line1[1]);

        List<Customer> customerList = new ArrayList<>();
        int windows[] = new int[K];
        Arrays.fill(windows, 8*60*60);

        for(int i=0; i<N; i++){
            String[] line = (bufferedReader.readLine()).split(" ");
            String[] times = line[0].split(":");
            Customer c = new Customer();
            c.arrivingTime = Integer.parseInt(times[0])*60*60+Integer.parseInt(times[1])*60+Integer.parseInt(times[2]);
            c.processingTime = Integer.parseInt(line[1])*60;
            if(c.arrivingTime<=17*60*60)
                customerList.add(c);
        }
        bufferedReader.close();

        Collections.sort(customerList);

        int sum = 0;
        for(int i=0; i<customerList.size(); i++){
            int minId = 0;
            for(int j=1; j<K; j++){
                if(windows[minId]>windows[j]){
                    minId = j;
                }
            }
            Customer c = customerList.get(i);
            c.startTime = (windows[minId]<c.arrivingTime?c.arrivingTime:windows[minId]);
            windows[minId] = c.startTime + c.processingTime;
            sum += c.startTime-c.arrivingTime;
        }
        double res = (sum*1.0)/(customerList.size()*60);
        System.out.printf("%.1f\n", res);

    }
}

class Customer implements Comparable<Customer> {
    int startTime;
    int arrivingTime;
    int processingTime;

    @Override
    public int compareTo(Customer c) {
        if(this.arrivingTime<c.arrivingTime) return -1;
        else if(this.arrivingTime==c.arrivingTime) return 0;
        else return 1;
    }
}
