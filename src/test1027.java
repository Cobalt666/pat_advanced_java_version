package pat;

import java.util.Scanner;

public class test1027 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("#");
        for(int i=0; i<3; i++){
            int decimal = scanner.nextInt();
            char c1 = (char) (decimal/13<=9 ? (decimal/13+'0') : (decimal/13-10+'A'));
            char c2 = (char) (decimal%13<=9 ? (decimal%13+'0') : (decimal%13-10+'A'));
            System.out.printf("%c%c", c1,c2);
        }
    }
}
