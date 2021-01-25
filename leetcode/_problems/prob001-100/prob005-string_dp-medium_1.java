/*
	# 5. Longest Palindromic Substring
	- Difficulty : Medium
	- Related Topics : String, Dynamic Programming
	- Runtime : 1001ms - O(n^2), Memory : 39.9MB
	- How to reduce Complexity? : reusing some previous computation - O(1)
*/
class Solution {
    public String longestPalindrome(String s) {
		
		for (int i = s.length(); i > 0; i--) {
			for (int j = 0; j < s.length() - i + 1; j++) {
				if (isPalindromicStr(s.substring(j, j+i))) {
					return s.substring(j, j+i);
				}
			}
		}
		
		return "";
    }
	
	public boolean isPalindromicStr(String s) {
		
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-i-1)) {
				return false;
			}
		}
		
		return true;
	}
}