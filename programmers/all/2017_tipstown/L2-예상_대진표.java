class Solution {
    public int solution(int n, int a, int b) {
        int remain = n;
        int one = Math.min(a, b);
        int other = Math.max(a, b);
        int round = 1;
        
        while (!check(one, other) && remain > 0) {
            remain = remain / 2;
            one = getNextRoundNumber(one);
            other = getNextRoundNumber(other);
            round++;
        }
        
        return round;
    }
    
    public boolean check(int a, int b) {
        return a % 2 == 1 && a + 1 == b;
    }
    
    public int getNextRoundNumber(int n) {
        return n % 2 == 0 ? n / 2 : n / 2 + 1;
    }
}