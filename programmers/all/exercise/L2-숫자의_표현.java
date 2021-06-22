class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (canExp(n, i)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean canExp(int n, int from) {
        int sum = 0;
        for (int i = from; i <= n; i++) {
            sum += i;
            if (sum == n) {
                return true;
            } else if (sum > n) {
                return false;
            }
        }
        
        return false;
    }
}