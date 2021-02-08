/*
	# 58. Length of Last Word
	- Difficulty : Easy
	- Related Topics : String
	- Runtime : 0ms, Memory : 37.1MB 
*/
class Solution {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		return s.substring(s.lastIndexOf(' ')+1).length();
	}
}