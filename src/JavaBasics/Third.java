package JavaBasics;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Third {
    public static void main(String[] args) {
        System.out.println("Area of isoceles traingle is");
        Scanner in = new Scanner(System.in);
        double a=in.nextInt();


        System.out.println(sqrt(3)/4*a*a);
    }
}
