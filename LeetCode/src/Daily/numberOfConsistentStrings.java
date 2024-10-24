package Daily;

import java.util.Stack;

public class numberOfConsistentStrings {
    public static void main(String[] args) {

    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < allowed.length() ; i++) {
            st.push(allowed.charAt(i));
        }
        for(int i=0;i < words.length;i++){
            count += check(words[i],st);
        }
        return count;
    }

    static int check(String given,Stack st){
        for (int i = 0; i < given.length() ; i++){
            if(!st.contains(given.charAt(i))){
                return 0;
            }
        }
        return 1;
    }
}
