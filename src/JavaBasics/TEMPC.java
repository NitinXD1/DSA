package JavaBasics;

import java.util.Scanner;

public class TEMPC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Enter degree centrigrade");
        float centigrade = input.nextFloat();

        float farenheit = centigrade*9/5+32;
        System.out.println(farenheit);


    }
}
