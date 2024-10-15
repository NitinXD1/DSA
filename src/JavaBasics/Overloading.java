package JavaBasics;

public class Overloading {
    public static void main(String[] args) {
number(67);
number ("nitin");
    }
    static void  number(String b){
        System.out.println(b);
    }
    static void number(int a){

        System.out.println(a);
    }
}
