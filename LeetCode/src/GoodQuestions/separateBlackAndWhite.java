package GoodQuestions;

public class separateBlackAndWhite {
    public static void main(String[] args) {

    }
    public long minimumSteps(String s) {
        int indexOf1black = 0;
        while(indexOf1black < s.length() && s.charAt(indexOf1black) != '1') indexOf1black++;
        long cnt = 0;
        for (int i = indexOf1black; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
              cnt += i - indexOf1black;
              indexOf1black++;
            }
        }
        return cnt;
    }
}
