package JavaBasics;

import java.util.Scanner;

/*
import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.print(Check(n));
    }

    static boolean Check(int n) {
        int num=2;
        if (n == 0 || n == 1) {
            return false;
        } while (num*num <= n) {

            if (n%num== 0)
            {
                return false;
            }
            num++;

        }
        return num * num > n;
    }
}
*/
class Questions {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter 3 digit number");
//        int num = in.nextInt();
//        System.out.println(Check(num));

        for(int i=100;i<1000;i++){
            if (Check(i)){
                System.out.println(i+"");
            }
        }
    }

    static boolean Check(int no) {
        int original = no;
        int sum = 0;

        while (no > 0) {
            int rem = no % 10;
            no = no / 10;
            sum = sum + rem * rem * rem;
            if (sum == original) return true;

        }
        return false;
    }
}
