/*
    # 31. Next Permutation
    - Difficulty : Medium
    - Related Topics : Array
    - Runtime : 1ms, Memory : 38.9MB
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int index = nums.length-1;
        
        while (index > 0 && nums[index] <= nums[index-1]) {
            index--;
        }
        
        if (index > 0) {
            int i = nums.length-1;
            
            while (i >= index) {
                if (nums[i] > nums[index-1]) {
                    int tmp = nums[i];
                    nums[i] = nums[index-1];
                    nums[index-1] = tmp;
                    break;
                }
                
                i--;
            }
        }
        
        reverseArrayFromIndex(nums, index);
    }
    
    public void reverseArrayFromIndex(int[] nums, int index) {
        int left = index;
        int right = nums.length-1;
        
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            
            left++;
            right--;
        }
    }
    
}