package Daily;

public class replaceChalks1894 {
    public static void main(String[] args) {
        int [] arr = {5,1,5};
        System.out.println(chalkReplacer(arr,22));
    }
    static int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        int ans = -1;
        for (int student : chalk) {
            sum += student;
        }
        k= (int)(k%sum);
        for (int i = 0; i < chalk.length ; i++) {
            if(k - chalk[i] < 0){
                ans = i;
                break;
            }
            k = k-chalk[i];
        }
        return ans;
    }

    static int chalkReplacerBest(int [] chalk,int k){
        int n = chalk.length;
        long [] prefix = new long[n];
        prefix[0] = chalk[0];
        for (int i = 1; i < n ; i++) {
            prefix[i] = prefix[i-1] + chalk[i];
        }
        k %= prefix[n-1];
        int left = 0;
        int right = n-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(prefix[mid] <= k){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
