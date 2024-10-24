package Daily;

import java.util.ArrayList;

public class Inclusion {
    public static void main(String[] args) {

    }

    static ArrayList<String> permus = new ArrayList<>();
    public static boolean checkInclusion(String s1, String s2) {
        getPermu(s1,"");
        for (int i = 0; i < permus.size() ; i++) {
            if(s2.contains(permus.get(i))){
                return true;
            }
        }
        return false;
    }

    public static void getPermu(String up,String p){
        if(up.isEmpty()){
            permus.add(p);
            return;
        }

        for(int i = 0;i < up.length();i++){
            char ch = up.charAt(i);
            String remaining = up.substring(0, i) + up.substring(i+1);
            getPermu(remaining, p + ch);
        }
    }
}
