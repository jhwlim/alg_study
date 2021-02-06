/*
	# 38. Count and Say
	- Difficulty : Easy
	- Related Topics : String
	- Runtime : 2ms, Memory : 36.7MB
*/
class Solution {

	public String countAndSay(int n) {
		
		String prevStr = "1";

		for (int i = 1; i < n; i++) {
			prevStr = countSameNumberInStr(prevStr);			
		}

		return prevStr;
	}

	public String countSameNumberInStr(String str) {
		
		if (str.length() == 1) {
			return 1 + str;
		}
		
		StringBuilder result = new StringBuilder();
		
		int cnt = 1;
		char prev = str.charAt(0);
		
		for (int i = 1; i < str.length(); i++) {
			
			if (str.charAt(i) == prev) {
				cnt++;
			} else {
				result.append(cnt);
				result.append(str.charAt(i-1));
				cnt = 1;
				prev = str.charAt(i);
			}
			
			if (i == str.length()-1) {
				result.append(cnt);
				result.append(str.charAt(i));
			}
		}

		return result.toString();
	}
}