class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            sum += getNumber(absolutes[i], signs[i]);
        }
        
        return sum;
    }
    
    private int getNumber(int abs, boolean sign) {
        return sign ? abs : abs * (-1);
    }
    
}