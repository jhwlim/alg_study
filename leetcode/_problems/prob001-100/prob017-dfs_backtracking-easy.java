/*
	# 17. Letter Combinations of a Phone Number
	- Difficulty : Medium
	- Related Topics : String, Backtracking, Depth-first Search, Recursion
	- Runtime : 0ms, Memory : 38.1MB
*/
class Solution {
	static String[] digitToLetters = {
		null,
		null,
		"abc",
		"def", 
		"ghi",
		"jkl",
		"mno",
		"pqrs",
		"tuv",
		"wxyz"
	};

	public List<String> letterCombinations(String digits) {
		
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<String>();
		
		if (digits.length() > 0) {
			doRecursive(digits, 0, sb, list);
		}
		
		return list;
	}

	public void doRecursive(String digits, int depth, StringBuilder result, List<String> list) {
		if (depth == digits.length()) {
			list.add(result.toString());
			return;
		}
		
		int idx = digits.charAt(depth) - '0';
		
		for (int i = 0; i < digitToLetters[idx].length(); i++) {	
			result.append(digitToLetters[idx].charAt(i));
			doRecursive(digits, depth+1, result, list);
			result.deleteCharAt(depth);
		}
		
	}
}