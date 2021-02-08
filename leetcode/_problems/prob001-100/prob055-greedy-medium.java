/*
	# 55. Jump Game
	- Difficulty : Medium
	- Related Topics : Array, Greedy
	- Runtime : 2ms, Memory : 40.8MB 
*/
class Solution {
	public boolean canJump(int[] nums) {
		
		int maxDest = 0;
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] += i;
			maxDest = Math.max(nums[i], maxDest);
			
			if (maxDest >= nums.length-1) {
				return true;
			} else if (maxDest == i) {
				return false;
			}
		}
		
		return true;
	}
}