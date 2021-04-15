package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bufferedReader.readLine().split(" ");
        int M = Integer.parseInt(line1[0]);
        int N = Integer.parseInt(line1[1]);
        int K = Integer.parseInt(line1[2]);
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<K; i++){
            String[] line = bufferedReader.readLine().split(" ");
            stack.clear();
            int e = 1;
            boolean flag = true;
            for(String str: line){
                int nowPop = Integer.parseInt(str);
                if(stack.empty()||stack.peek()<nowPop){
                    while(e<=N&&e<=nowPop&&stack.size()<M){
                        stack.push(e++);
                    }
                }
                if(stack.empty()||stack.peek()!=nowPop){
                    System.out.println("NO");
                    flag=false;
                    break;
                }else{
                    stack.pop();
                }
            }
            if(flag){
                System.out.println("YES");
            }
        }
    }
}
