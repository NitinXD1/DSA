package JavaBasics;

import java.util.Scanner;

public class Fibonaaci {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0;
        int b = 1;
        int num =2;
        while(num<=n){
            int temp = b;
           b=b+a;
            a = temp;
            num++;
        }
        System.out.println(b);
    }
}
