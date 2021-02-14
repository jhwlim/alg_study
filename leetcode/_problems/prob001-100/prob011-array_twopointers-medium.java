/*
	# 11. Container With Most Water
	- Difficulty : Medium
	- Related Topics : Array, Two Pointers
	- Runtime : 2ms, Memory : 40.8MB
	- Concept : left/right endpoint 중 작은 숫자를 하나씩 좁혀가면서 큰 수로 바꿔야 최댓값을 찾을 수 있다.
*/
class Solution {
	public int maxArea(int[] height) {
		int left= 0;
		int right = height.length-1;
		
		int max = 0;
		int tmp = 0;
		
		while (left < right) {
			tmp = (right - left) * Math.min(height[right], height[left]);
			max = Math.max(max, tmp);
			
			if (height[left] > height[right]) {
				right--;
			} else if (height[left] < height[right]) {
				left++;
			} else {
				left++;
				right--;
			}
		}
		
		return max;
	}
}