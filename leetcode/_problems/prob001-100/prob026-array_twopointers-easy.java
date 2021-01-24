/*
	# 26. Remove Duplicates from Sorted Array
	- Difficulty : Easy
	- Related Topics : Array, Two Pointers
	- Runtime : 1ms, Memory : 44.9MB
*/
class Solution {
    public int removeDuplicates(int[] nums) {
		
		int idx = 0;
		int num = -10001; // -10000 <= nums[i] <= 10000
		
		for (int i = 0; i < nums.length; i++) {
			if (num == nums[i]) {
				continue;
			} else {
				nums[idx++] = nums[i];
				num = nums[i];
			}
		}
		return idx;
    }
}