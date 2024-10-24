package Contest;
//DP question
public class maximumValidStrings {
    public static void main(String[] args) {
        String target = "ababaababa";
        String[] words = {"abababab","ab"};
        System.out.println(minValidStrings(words,target));
    }

    public static int minValidStrings(String[] words, String target) {
        //array has to be sorted as in a overlapping case itll not work
        int cnt = 0;
        for (int i = 0; i < words.length ; i++) {
            while (target.contains(words[i])){
                target = target.replace(words[i], "");
                cnt++;
            }
        }
        return cnt;
    }
}
