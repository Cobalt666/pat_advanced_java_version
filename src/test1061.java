package pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1061 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder[] lines = new StringBuilder[4];
        for(int i=0; i<4; i++){
            lines[i] = new StringBuilder(bufferedReader.readLine().trim());
        }
        int dayOfWeek = -1, hourOfDay=-1;
        for(int i=0; i<lines[0].length()&&i<lines[1].length(); i++){
            if(lines[0].charAt(i)==lines[1].charAt(i)){
                char c = lines[0].charAt(i);
                if(dayOfWeek == -1&& c >= 'A' && c <= 'G'){
                    dayOfWeek = c - 'A';
                    continue;
                }
                if(dayOfWeek != -1&&((c >= 'A' && c <= 'N')||Character.isDigit(c))){
                    if(Character.isDigit(c)){
                        hourOfDay = c - '0';
                    }else{
                        hourOfDay = c - 'A' + 10;
                    }
                    break;
                }
            }
        }
        int minOfDay=-1;
        for(int i=0; i<lines[2].length()&&i<lines[3].length(); i++){
            if(lines[2].charAt(i)==lines[3].charAt(i)&&Character.isAlphabetic(lines[2].charAt(i))){
                minOfDay = i;
                break;
            }
        }
        String[] week = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        System.out.printf("%s %02d:%02d\n", week[dayOfWeek], hourOfDay, minOfDay);
    }
}
