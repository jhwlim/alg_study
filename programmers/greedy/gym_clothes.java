import java.util.*;

// 탐욕법 > 체육복
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        boolean[] has = new boolean[n+1];
        Arrays.fill(has, true);
        int cnt = n;

        for (int i = 0; i < lost.length; i++) {
            has[lost[i]] = false;
        }
        cnt -= lost.length;

        int num = 0;
        boolean[] isChecked = new boolean[reserve.length];

        for (int i = 0; i < reserve.length; i++) {
            num = reserve[i];
            if (!has[num]) {
                has[num] = true;
                isChecked[i] = true;
                cnt++;
            }
        }
        for (int i = 0; i < reserve.length; i++) {
            if (isChecked[i]) {
                continue;
            }

            num = reserve[i];
            if (num-1 >= 1 && !has[num-1]) {
                has[num-1] = true;
                cnt++;
            } else if (num+1 <= n && !has[num+1]) {
                has[num+1] = true;
                cnt++;
            }
        }

        return cnt;
    }
}