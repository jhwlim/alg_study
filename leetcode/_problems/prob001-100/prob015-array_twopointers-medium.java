/*
	# 15. 3Sum
	- Difficulty : Medium
	- Related Topics : Array, Two Pointers
	- Runtime : 69ms, Memory : 42.7MB
	  → Runtime needed to be improved!
*/
class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		
		Arrays.sort(nums);   
		
		int firstIndexOfZero = -1;
		int lastIndexOfZero = -1;
		
		int tmp = 0;
		int idx = 0;
		
		for (int left = 0; left < nums.length; left++) { 
			if (nums[left] > 0) {
				if (firstIndexOfZero == -1 || nums[left] == 0) {
					firstIndexOfZero = left;
				}
				break;
			}
			
			if (left > 0 && nums[left] == nums[left-1]) {
				continue;
			}
			
			for (int right = nums.length-1; right >= 0; right--) {
				if (nums[right] < 0) {
					if (lastIndexOfZero == -1 || nums[right] == 0) {
						lastIndexOfZero = right;
					}
					break;
				}
				
				if (right < nums.length-1 && nums[right] == nums[right+1]) {
					continue;
				}
				
				tmp = (nums[left] + nums[right]) * (-1);
				if (left+1 <= right) {
					idx = Arrays.binarySearch(nums, left+1, right, tmp);
					if (idx >= 0) {
						result.add(new ArrayList<>(Arrays.asList(nums[left], nums[idx], nums[right])));
					}    
				}
			}
		}
		
		return result;
	}

}