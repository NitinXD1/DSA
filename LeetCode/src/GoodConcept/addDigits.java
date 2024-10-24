package GoodConcept;

public class addDigits {
    public static void main(String[] args) {

    }

    public static int addDigits(int num) {
        int ans = 0;
        while(num / 10 != 0){
            ans += num % 10;
            num = num/10;
        }
        if(num > 9) return addDigits(ans);
        return ans;
    }
}
