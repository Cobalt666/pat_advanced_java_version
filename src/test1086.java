package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test1086 {
    static int[] preList,inList,postList;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        preList = new int[N];
        inList = new int[N];
        postList = new int[N];
        int cnt1=0, cnt2=0, X;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<2*N; i++){
            String[] line = bufferedReader.readLine().split("\\s");
            if(line.length==2){//Push X
                X = Integer.parseInt(line[1]);
                preList[cnt1++]=X;
                stack.push(X);
            }else{//Pop
                X=stack.pop();
                inList[cnt2++]=X;
            }
        }
        test1086 main1 = new test1086();
        main1.post(0,N-1,0,N-1);
        System.out.print(postList[0]);
        for(int i=1; i<N; i++){
            System.out.print(" "+postList[i]);
        }
    }

    void post(int preL, int preR, int inL, int inR){
        if(preL>preR)return;
        int root = preList[preL];
        int delta = 0;
        while(inList[inL+delta]!=root&&inL+delta<=inR){
            delta++;
        }
        post(preL+1, preL+delta, inL, inL+delta-1);
        post(preL+delta+1, preR, inL+delta+1, inR);
        postList[cnt++]=root;
    }
}
