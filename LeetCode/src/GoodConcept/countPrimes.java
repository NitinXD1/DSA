package GoodConcept;

public class countPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
    public static int countPrimes(int n) {
        int [] primes = new int[n+1];
        //marking every index
        for (int i = 0; i < primes.length ; i++) {
            primes[i] = 1;
        }

        for (int i = 2; i*i < n ; i++) {
            if(primes[i] == 1){
                for (int j = i*i; j <= n ; j+=i) {
                    primes[j] = 0;
                }
            }
        }

        int cnt = 0;

        for (int i = 2; i <primes.length ; i++) {
            if(primes[i]==1){
                cnt++;
            }
        }
        return cnt;
    }
}
