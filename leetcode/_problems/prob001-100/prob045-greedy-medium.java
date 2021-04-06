/*
	# 45. Jump Game II
	- Difficulty : Medium
	- Related Topics : Array, Greedy
	- Runtime : 0ms, Memory : 36.6MB
*/
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        int[] minOfJump = new int[nums.length];
        
        int idx = 0;
        
        while (minOfJump[nums.length-1] == 0) {
            int lenOfJump = nums[idx];
            int n = minOfJump[idx];
            
            for (int i = idx+1; i <= idx + lenOfJump; i++) {
                if (i < minOfJump.length) {
                    int m = minOfJump[i];
                    if (m == 0) {
                        minOfJump[i] = n+1;    
                    } else if (m > 0) {
                        minOfJump[i] = Math.min(n+1, m);    
                    }
                        
                }
                
            }
            
            idx++;
        }
        
        return minOfJump[nums.length-1];
    }
}