package Daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class uncommonWords {
    public static void main(String[] args) {

    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        String[] sentence1 = s1.split(" ");
        String[] sentence2 = s2.split(" ");
        HashMap<String,Integer> mpp = new HashMap<>();

        for(String word1 : sentence1) mpp.put(word1,mpp.getOrDefault(word1,0)+1);
        for(String word2 : sentence2) mpp.put(word2,mpp.getOrDefault(word2,0)+1);

        ArrayList<String> list = new ArrayList<>();
        for(String word : mpp.keySet()){
            if(mpp.get(word) == 1) list.add(word);
        }

        return list.toArray(new String[list.size()]);
    }
}
