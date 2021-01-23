/*
	# 20. Valid Parentheses
	- Difficulty : Easy
	- Related Topics : String, Stack
	- Runtime : 4ms, Memory : 39.1MB
*/
class Solution {
    static String brackets = "(){}[]";
	
	public boolean isValid(String s) {
		
		if (s.length() % 2 != 0) {
			return false;
		}
		
		Stack<Integer> stack = new Stack<>();
		char c = '0';
		int idxOfBrackets = 0;
		
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			idxOfBrackets = brackets.indexOf(c);
			if (idxOfBrackets % 2 == 0) {
				stack.push(idxOfBrackets);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				
				if (idxOfBrackets-1 == stack.peek()) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
}