package GoodConcept;

import java.util.HashMap;
import java.util.Map;

public class reformatDate {
    public static void main(String[] args) {

    }

    public String reformatDate(String date) {
        String[] array = date.split(" ");
        StringBuilder sb = new StringBuilder();
        Map<String,String> monthsMap = new HashMap<>();
        monthsMap.put("Jan", "01");
        monthsMap.put("Feb", "02");
        monthsMap.put("Mar", "03");
        monthsMap.put("Apr", "04");
        monthsMap.put("May", "05");
        monthsMap.put("Jun", "06");
        monthsMap.put("Jul", "07");
        monthsMap.put("Aug", "08");
        monthsMap.put("Sep", "09");
        monthsMap.put("Oct", "10");
        monthsMap.put("Nov", "11");
        monthsMap.put("Dec", "12");
        int i = 2;
        while(i >= 0){
            if(i == 2){
                sb.append(array[i]);
                sb.append("-");
            }else if(i == 1){
                sb.append(monthsMap.get(array[i]));
                sb.append("-");
            }else{
                if(Character.isDigit(date.charAt(0)) && Character.isDigit(date.charAt(1))){
                    sb.append(date.substring(0,2));
                }else{
                    sb.append("0");
                    sb.append(date.substring(0,1));
                }
            }
            i--;
        }
        return sb.toString();
    }
}
