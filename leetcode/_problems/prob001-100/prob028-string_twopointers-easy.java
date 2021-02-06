/*
	# 28. Implement strStr()
	- Difficulty : Easy
	- Related Topics : String, Two Pointers
	- Runtime : 3ms, Memory : 37.6MB 
*/
class Solution {
	public int strStr(String haystack, String needle) {

		if (needle.length() == 0) {
			return 0;
		}

		int needleIdx = 0;
		
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(needleIdx)) {
				needleIdx++;
				if (needleIdx == needle.length()) {
					return i - needleIdx + 1;
				}
			} else {
				i = i - needleIdx;
				needleIdx = 0;
			}
		}
		
		return -1;
	}
}