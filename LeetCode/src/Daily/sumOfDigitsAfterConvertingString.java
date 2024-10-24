package Daily;

import javax.lang.model.type.MirroredTypesException;

public class sumOfDigitsAfterConvertingString {
    public static void main(String[] args) {
        System.out.println(getLucky("zbax",1));
    }
    public static int getLucky(String s, int k) {
        StringBuilder num = new StringBuilder();
        for (char c : s.toCharArray()) {
            int value = c - 'a' + 1; // 'a' -> 1, 'b' -> 2, ..., 'z' -> 26
            num.append(value);
        }

        // Step 2: Sum of digits transformation
        int sum = 0;
        for (char digit : num.toString().toCharArray()) {
            sum += digit - '0';
        }

        for (int i = 1; i < k ; i++) {
            int tempSum = 0;
            while (sum > 0){
                tempSum += sum%10;
                sum = sum/10;
            }
            sum = tempSum;
        }
        return sum;

    }
}
