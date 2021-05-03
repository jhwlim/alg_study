/*
    # 215. Kth Largest Element in an Array
    - Difficulty : Medium
    - Related Topics : Heap, Divide and Conquer
    - Runtime : 1ms, Memory : 39.5MB 
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        
        return nums[nums.length - k];
    }
}