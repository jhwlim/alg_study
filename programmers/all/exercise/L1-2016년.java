import java.util.*;

class Solution {
    
    private static final String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"}; 
    private static final int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int start = 5; // FRI
    
    public String solution(int a, int b) {
        int total = start+b-1;
        for (int i = 1; i < a; i++) {
            total += months[i-1];
        }
        return days[total % 7];
    }
}