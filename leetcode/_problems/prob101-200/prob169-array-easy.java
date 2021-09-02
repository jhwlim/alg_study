/*
	# 169. Majority Element
	- Difficulty : Easy
	- Related Topics : Array, Sorting, Counting
	- Runtime : 3ms, Memory : 54.5MB
*/
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}