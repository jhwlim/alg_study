import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;

        for (int i = 0; i < citations.length; i++) {
            int n = citations[i];
            int more = citations.length - i;

            int tmp = Math.min(n, more);
            max = Math.max(tmp, max);
        }

        return max;
    }
}
