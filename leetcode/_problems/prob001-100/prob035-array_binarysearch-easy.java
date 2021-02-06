/*
	# 35. Search Insert Position
	- Difficulty : Easy
	- Related Topics : Array, Binary Search
	- Runtime : 0ms, Memory : 39.2MB
*/
class Solution {
	public int searchInsert(int[] nums, int target) {

		int prev = -1;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return i;
			} else if (nums[i] < target) {
				prev = i;
			} else {
				break;
			}
		}
		
		return prev + 1;
	}
}