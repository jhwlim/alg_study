import java.util.*;

// 탐욕법 > 구명보트
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int right = people.length-1;
        int left = 0;
        int cnt = 0;
        
        for (; left <= right; right--) {
            cnt++;
            if (people[left] + people[right] <= limit) {
                left++;
            }
        }
        
        return cnt;
    }
}