class Solution {
    public int solution(int n) {
        return findNumberOfPrimeNumber(n);
    }
    
    public int findNumberOfPrimeNumber(int n) {
        boolean[] numbers = new boolean[n+1];
        int notPrime = 1;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!numbers[i]) {
                for (int j = 2; i * j <= n; j++) {
                    if (!numbers[i * j]) {
                        notPrime++;
                        numbers[i * j] = true;
                    }
                }
            } 
        }
        
        return n - notPrime;
    }
}