/*
	# 136. Single Number
	- Difficulty : Easy
	- Related Topics : Array, Bit Manipulation
	- Runtime : 5ms, Memory : 38.8MB
*/
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        int i = 0;
        for (; i < nums.length; i += 2) {
            if (i+1 < nums.length && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        
        return nums[i-2];
    }
}