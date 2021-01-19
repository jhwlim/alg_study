/*
	# 9. Palindrome Number
	- Difficulty : Easy
	- Related Topics : Math
*/
class Solution {
	public boolean isPalindrome(int x) {
		
		if (x >= 0) {
			String strNum = String.valueOf(x);
			char c = 0;
			int len = strNum.length();
			
			for (int i = 0; i < len / 2; i++) {
				c = strNum.charAt(i);
				if (c != strNum.charAt(len - 1 - i)) {
					return false;
				}
			}
			return true;
		}
		
		return false;
	}
}