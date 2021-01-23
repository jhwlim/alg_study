/*
	# 13. Roman to Integer
	- Difficulty : Easy
	- Related Topics : Math, String
*/
class Solution {
    private static String romanChars = "IVXLCDM";
	private static int[] romanCharNumArr = {1, 5, 10, 50, 100, 500, 1000};
	
	public int romanToInt(String s) {
       	int result = 0;
       	int cnt = 1;
       	char c = 0, c2 = 0;
       	int idx = 0, nextIdx = 0;;
       	
		for (int i = 0; i < s.length(); i++) {
       		c = s.charAt(i);
       		idx = romanChars.indexOf(c);
       		
       		if (i == s.length()-1) {
           		result += romanCharNumArr[idx] * cnt;
           		break;
       		}
       		
       		c2 = s.charAt(i+1);
       		nextIdx = romanChars.indexOf(c2);
           	if (idx != 6 && idx % 2 == 0 && idx < nextIdx) {
           		result += romanCharNumArr[nextIdx] - romanCharNumArr[idx];
           		i++;
           		continue;
           	} else if (idx == nextIdx) {
           		cnt++;
           	} else {
           		result += romanCharNumArr[idx] * cnt;
           		cnt = 1;
           	}
       	}
		
		return result;
    }
}