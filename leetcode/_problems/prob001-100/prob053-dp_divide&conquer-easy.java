/*
	# 53. Maximum Subarray
	- Difficulty : Easy
	- Related Topics : Array, Divide and Conquer, Dynamic Programming
	- Runtime : 434ms, Memory : 41.6MB 
		→ O(n^2) : too bad! need to be improved
*/
class Solution {
    
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		
		int[] sums = new int[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				sums[i] += nums[j];
			}
		}
		
		for (int begin = 0; begin < nums.length; begin++) {
			max = Math.max(nums[begin], max);
			max = Math.max(sums[begin], max);
			
			for (int finish = begin+1; finish < nums.length; finish++) {
				max = Math.max(sums[finish] - sums[begin], max);
			}
		}
		
		return max;
    }
	
}