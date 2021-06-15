/*
	# 62. Unique Paths
	- Difficulty : Medium
	- Related Topics : Array, Dynamic Programming
	- Runtime : 0ms, Memory : 35.4MB
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int a = m + n - 2;
        int b = 1;
        long answer = 1;
        if (n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        
        for (int i = 0; i < n-1; i++) {
            answer *= a - i;
            answer /= b + i;
        }
        return (int) answer;
    }
}