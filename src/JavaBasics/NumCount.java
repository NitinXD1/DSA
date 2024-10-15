package JavaBasics;

import java.util.Scanner;

public class NumCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=55558;
        int count=0;
        while(n>0)
        {
            int rem = n%10;
            if (rem ==5){
                count++;
            }
            n=n/10;
        }
    System.out.println(count);
    }
}
