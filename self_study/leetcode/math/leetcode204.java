// # 204. Count Primes : Easy
class Solution {
    public int countPrimes(int n) {
        boolean[] arr = new boolean[n]; // not prime number -> true
        int cnt = 0;
        int last = 0;

        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                cnt++;

                if (last * last < arr.length) last = i; 
                else continue;

                for (int j = 2; i * j < n; j++) {
                    arr[i * j] = true;
                }
            }
        }

        return cnt;
    }
}