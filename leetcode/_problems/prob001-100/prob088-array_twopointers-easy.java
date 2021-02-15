/*
	# 88. Merge Sorted Array
	- Difficulty : Easy
	- Related Topics : Array, Two Pointers
	- Runtime : 0ms, Memory : 39MB 
*/
class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		
		int i1 = m-1;
		int i2 = n-1;
		int idx = m+n-1;
		
		while (idx >= 0) {
			if (i1 < 0) {
				nums1[idx--] = nums2[i2--];
				continue;
			}
			
			if (i2 < 0) {
				nums1[idx--] = nums1[i1--];
				continue;
			}
			
			if (nums1[i1] >= nums2[i2]) {
				nums1[idx--] = nums1[i1--];
			} else {
				nums1[idx--] = nums2[i2--];
			}
		}
		
	}
}