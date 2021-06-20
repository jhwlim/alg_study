class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                sum -= i;
            } else {
                sum += i;
            }
        }   
        
        return sum;
    }
    
}