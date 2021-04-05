/*
	# 189. Rotate Array
	- Difficulty : Medium
	- Related Topics : Array
	- Runtime : 1ms, Memory : 39.4MB
*/
class Solution {
    public void rotate(int[] nums, int k) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];    
        }
        
        for (int i = 0; i < nums.length; i++) {
            int idx = (i-k) % nums.length;
            if (idx < 0) {
                idx += nums.length;
            }
            nums[i] = tmp[idx];
        }
    }
}