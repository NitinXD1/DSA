package JavaBasics;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        int a = 1651654;
        while(a>0)
        {
            int rem = a%10;
            if(a>0)
            {
                System.out.print(rem);
            }
            a=a/10;
        }

    }
}

