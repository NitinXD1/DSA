package GoodQuestions;

public class uglyNumber2 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    public static int nthUglyNumber(int n) {
        int count = 0;
        int number = 1;
        while(count < n){
            if(isUgly(number)){
                count++;
            }
            if(count < n){
                number++;
            }
        }
        return number;
    }

    public static boolean isUgly(int n) {
        while(n>1 && (n%2==0 || n%3==0 || n%5==0)){
            if(n%2==0)n=n/2;
            if(n%3==0)n=n/3;
            if(n%5==0)n=n/5;
        }
        if(n==1) return true;
        else{
            return false;
        }
    }
}
