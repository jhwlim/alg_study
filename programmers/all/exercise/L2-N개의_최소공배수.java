import java.util.*;

class Solution {
    
    private static boolean[] isPrimes;
    private static List<Integer> primeNumbers;
    private static final int MAX_VALUE = 100;
    
    static {
        isPrimes = new boolean[MAX_VALUE+1];
        Arrays.fill(isPrimes, true);
        
        isPrimes[0] = false;
        isPrimes[1] = false;
        
        for (int i = 2; i < Math.sqrt(MAX_VALUE); i++) {
            if (isPrimes[i]) {
                for (int j = 2; i * j <= MAX_VALUE; j++) {
                    isPrimes[i * j] = false;
                }
            }
        }
        
        primeNumbers = new ArrayList<>();
        for (int i = 2; i < isPrimes.length; i++) {
            if (isPrimes[i]) {
                primeNumbers.add(i);
            }
        }
    }
    
    public int solution(int[] arr) {
        int[] efficientCounts = new int[primeNumbers.size()];
        for (int i : arr) {
            convertEfficientCounts(efficientCounts, i);
        }
        
        int result = 1;
        for (int i = 0; i < efficientCounts.length; i++) {
            int e = efficientCounts[i];
            if (e > 0) {
                result *= Math.pow(primeNumbers.get(i), e);
            }
        }
        
        return result;
    }
    
    public void convertEfficientCounts(int[] efficientCounts, int n) {
        for (int i = 0; i < primeNumbers.size(); i++) {
            int m = primeNumbers.get(i);
            int cnt = 0;
            while (n > 1 && n % m == 0) {
                cnt++;
                n /= m;
            }
            
            efficientCounts[i] = Math.max(cnt, efficientCounts[i]);
        }
    }
    
}