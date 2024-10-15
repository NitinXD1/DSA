package JavaBasics;

import java.util.Arrays;

public class VarArgrs {
    public static void main(String[] args) {
        fun (4,54,4,54,46,64,564654,6465,151,1);
        fum(6,5,"nitin");
    }
static void fum(int a, int b  ,String ...v){


}
    static void fun(int ...v){
        System.out.println(Arrays.toString(v));

    }
}
