package JavaBasics;/*
 public class Functions {
     public static void main(String[] args)
     {
 String Hola= hello();
 System.out.print(Hola);

     }
     static String hello(){

         String Namaste="Bhai kaisa hai tu";
         return Namaste;
     }
 }
 int answer=sum();
 System.out.print("the sum is:"+answer);
*/

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

/*
Non returning functions call by sum();
  static void sum()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first number:");
        int num1 = in.nextInt();
        System.out.print("Enter second number");
        int num2 =in.nextInt();

        int sum = num1+num2;
        System.out.println("The sum is :"+sum);

    }
    static int sum()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first number:");
        int num1 = in.nextInt();
        System.out.print("Enter second number");
        int num2 =in.nextInt();

        int sum= num1+num2;
return sum;
    }
*/
//passing the values when calling the method in main()
//class Functions {
//        public static void main(String[] args) {
//Scanner in = new Scanner(System.in);
//            System.out.print("Enter your name:");
//            String good =in.nextLine();
//            String greet= name(good);
//            System.out.print("Welcome "+greet);
//        }
//        static String name(String naam){
//            String greeting=(naam);
//
//            return greeting;
//
//        }
//    }
//












        //int ans = sum(50,86);
//System.out.print(ans);
//    }
//    static int sum(int a,int b){
//        int sum=a+b;
//        return sum;
//
//    }
//
//}

//JAVA ONLY HAS PASS BY VALUE

class Functions{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
    change(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void change(int []nums){

        nums[0]=99;
    }

}

