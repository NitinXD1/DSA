package Daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class minimumTimeDifference {
    public static void main(String[] args) {

    }
//        Collections.sort(timePoints);
//        int minTime = Integer.MAX_VALUE;
//        for (int i = 0; i < timePoints.size() - 1 ; i++) {
//            String time1 = timePoints.get(i);
//            int hour1 = Integer.parseInt(time1.substring(0,2));
//            int minutes1 = Integer.parseInt(time1.substring(3,5));
//            String time2 = timePoints.get(i+1);
//            int hour2 = Integer.parseInt(time2.substring(0,2));
//            int minutes2 = Integer.parseInt(time2.substring(3,5));
//            int currTime = (hour2 * 60 + minutes2) - (hour1 * 60 + minutes1);
//            minTime = Integer.min(minTime,currTime);
//        }
//        //checking for first and last also
//        String firstTime = timePoints.get(0);
//        int firstHour = Integer.parseInt(firstTime.substring(0, 2));
//        int firstMinutes = Integer.parseInt(firstTime.substring(3, 5));
//
//        String lastTime = timePoints.get(timePoints.size() - 1);
//        int lastHour = Integer.parseInt(lastTime.substring(0, 2));
//        int lastMinutes = Integer.parseInt(lastTime.substring(3, 5));
//
//        // Time difference wrapping around midnight
//        int circularTime = (24 * 60 - (lastHour * 60 + lastMinutes)) + (firstHour * 60 + firstMinutes);
//        minTime = Math.min(minTime, circularTime);
//
//        return minTime;

    public static int findMinDifference(List<String> timePoints) {
        int n =  timePoints.size();
        int [] minutes = new int[n];
        for (int i =0;i< n;i++) {
            minutes[i]=convertToMinutes(timePoints.get(i));
        }
        Arrays.sort(minutes);
        int smallesttime = Integer.MAX_VALUE;
        for(int i=1;i<minutes.length; i++){
            int diff = minutes[i] - minutes[i - 1];
            smallesttime= Math.min(smallesttime,diff);
        }
        // because time is actually circular so we need to check first ans last time also :
        int circularDiff = (1440 - minutes[n - 1] + minutes[0]);
        smallesttime = Math.min(smallesttime, circularDiff);

        return smallesttime;
    }

    public static int convertToMinutes(String time) {
        int hours = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int minutes = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        return hours * 60 + minutes;
    }
}
