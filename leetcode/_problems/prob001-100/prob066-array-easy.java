/*
	# 66. Plus One
	- Difficulty : Easy
	- Related Topics : Array
	- Runtime : 0ms, Memory : 37.6MB 
*/
class Solution {
	public int[] plusOne(int[] digits) {
		
		int head = 0;
		for (int i = digits.length - 1; i >= -1; i--) {
			if (i == -1) {
				head++;
				break;
			}
			
			digits[i] += 1;
			if (digits[i] == 10) {
				digits[i] = 0;
				continue;
			} else {
				break;    
			}
		}
		
		if (head == 0) {
			return digits;   
		} else {
			
			int[] result = new int[digits.length+1];
			
			result[0] = head;
			for (int i = 1; i < result.length; i++) {
				result[i] = digits[i-1];
			}
			return result;
		}
	}
}