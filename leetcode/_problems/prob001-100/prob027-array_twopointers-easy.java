/*
	# 27. Remove Element
	- Difficulty : Easy
	- Related Topics : Array, Two Pointers
	- Runtime : 0ms, Memory : 39.5MB
*/
class Solution {
    public int removeElement(int[] nums, int val) {
		
		int idx = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[idx++] = nums[i];
			}
		}
		
		return idx;
    }
	
}