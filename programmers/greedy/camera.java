import java.util.*;

// 탐욕법 > 단속카메라
class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, new Comparator<>() {

            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int min = 0;
        int cnt = 0;

        for (int i = 0; i < routes.length; i++) {
            int in = routes[i][0];
            int out = routes[i][1];

            if (i == 0) {
                min = out;
                continue;
            }
            if (in <= min) {
                min = Math.min(min, out);
            } else {
                cnt++;
                min = out;
            }
        }

        return cnt+1;
    }
}