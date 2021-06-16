import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (isCorrect((s + s).substring(i, i + len))) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (canPush(stack, c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    if (isPair(stack.peek(), c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
    
        return stack.isEmpty();
    }
    
    private boolean canPush(Stack s, char c) {
        return c == '[' || c == '{' || c == '(';
    }
    
    private boolean isPair(char open, char close) {
        return ((open == '[' && close == ']')
                || (open == '{' && close == '}')
                || (open == '(' && close == ')'));
    }
}