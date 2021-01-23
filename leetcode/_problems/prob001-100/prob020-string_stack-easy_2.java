/*
	# 20. Valid Parentheses
	- Difficulty : Easy
	- Related Topics : String, Stack
	- Runtime : 3ms, Memory : 38.5MB
*/
class Solution {
    public boolean isValid(String s) {
		
		if (s.length() % 2 != 0) {
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		char c = '0';
		
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				
				if (c == ')') {
					if (stack.pop() != '(') {
						return false;
					}
				} else if (c == '}') {
					if (stack.pop() != '{') {
						return false;
					}
				} else { // c == ']'
					if (stack.pop() != '[') {
						return false;
					}
				}
			}
			
		}
		
		return stack.isEmpty();
	}
}