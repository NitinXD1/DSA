package JavaBasics;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {

//
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter your fruit name");
//        String Fruit = in.next();
//
//        switch (Fruit) {
//            case "Mango":
//                System.out.println("King of fruits");
//                break;
//            case "Apple":
//                System.out.println("A sweet fruit");
//            default:
//                System.out.println("bad ones");
//        }

//OR
        //        switch (fruit) {
//            case "Mango" -> System.out.println("King of fruits");
//            case "Apple" -> System.out.println("A sweet red fruit");
//            case "Orange" -> System.out.println("Round fruit");
//            case "Grapes" -> System.out.println("Small fruit");
//            default -> System.out.println("please enter a valid fruit");
//        }

//NESTED SWITCH CONDITON

        Scanner in = new Scanner(System.in);
        String EmpID = in.nextLine();
        int Block = in.nextInt();
        switch (EmpID) {
            case "Science" -> System.out.println("Teacher of science department");
            case "Arts" -> System.out.println("Teacher of arts department");
            case "Commerce" -> System.out.println("Teacher of commmerce department");
            case "others" -> {
                switch (Block) {
                    case 1 -> System.out.println("Eastern Block");
                    case 2 -> System.out.println("Northern Block");
                    case 3 -> System.out.println("Middle block");
                    default -> System.out.println("Not a teacher");
                }
            }
            default -> System.out.println("Wrong info");
        }





        }





















    }

