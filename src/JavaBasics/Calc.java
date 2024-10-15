package JavaBasics;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        {
            Scanner input =new Scanner(System.in);
            System.out.print("choose operation:");
            char op = input.next().trim().charAt(0);
            if(op=='+'||op=='-'||op=='*'||op=='/'||op=='%')
            {
                int num1 = input.nextInt();
                int num2= input.nextInt();
                int ans;
                if(op=='+'){
                    ans=num1+num2;
                } else if (op=='-') {
                    ans=num1-num2;
                } else if (op=='*') {
                    ans=num1*num2;
                } else if (op=='%') {
                    ans=num1%num2;
                }else{
                    ans=num1/num2;
                }
                System.out.println(ans);


            }




        }
    }
}
