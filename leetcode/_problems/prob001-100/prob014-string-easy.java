/*
	# 14. Longest Common Prefix
	- Difficulty : Easy
	- Related Topics : String
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
		int minLen = findLowestStr(strs);
		if (minLen == 0) {
			return "";
		}
		
		char commonC = '0';
		boolean isCommonPrefix = true;
		int lastIdxOfCommonPrefix = 0;
		
		for (int i = 0; i < minLen; i++) {
			for (int j = 0; j < strs.length; j++) {
				if (j == 0) {
					commonC = strs[j].charAt(i);					
					continue;
				} 
				
				if (commonC != strs[j].charAt(i)) {
					isCommonPrefix = false;
					break;
				}
			}
			if (!isCommonPrefix) {
				lastIdxOfCommonPrefix = i;				
				break;
			} else if (i == minLen-1) {
				lastIdxOfCommonPrefix = i+1;
			}
		}
		return strs[0].substring(0, lastIdxOfCommonPrefix);
    }
	
	public int findLowestStr(String[] strs) {
		if (strs.length == 0) {
			return 0;
		}
		
		int minLen = strs[0].length();
		
		for (int i = 1; i < strs.length; i++) {
			minLen = Math.min(strs[i].length(), minLen);
		}
		
		return minLen;
	}
}