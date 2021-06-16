import java.util.*;

class Solution {
    
    private static final char[] operators = {'+', '-', '*'};
    private static final char[][] cases = {
        {'+', '-', '*'},
        {'+', '*', '-'},
        {'-', '+', '*'},
        {'-', '*', '+'},
        {'*', '-', '+'},
        {'*', '+', '-'},
    };
    
    public long solution(String expression) {
        long max = 0L;
        
        Queue<Long> longQueue = new LinkedList<>();
        Queue<Character> operatorQueue = new LinkedList<>();
            
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (isOperator(c)) {
                longQueue.add(Long.parseLong(sb.toString()));
                sb.delete(0, sb.length());
                operatorQueue.add(c);
            } else {
                sb.append(c);
            }
        }
        longQueue.add(Long.parseLong(sb.toString()));
        
        for (int i = 0; i < cases.length; i++) {
            max = Math.max(Math.abs(getResult(new LinkedList<>(longQueue), new LinkedList<>(operatorQueue), cases[i])), max);
        }
        return max;
    }
    
    private long getResult(Queue<Long> longQueue, Queue<Character> operatorQueue, char[] priority) {
        for (char p : priority) {
            long prev = longQueue.poll();
            int size = operatorQueue.size();
            if (size == 0) {
                return prev;
            }
            
            for (int i = 0; i < size; i++) {
                char c = operatorQueue.poll();
                long next = longQueue.poll();
                if (c == p) {
                    long result = calc(prev, next, c);
                    prev = result;
                } else {
                    operatorQueue.add(c);
                    longQueue.add(prev);
                    prev = next;
                    
                }
            }
            longQueue.add(prev);
        }
        
        return longQueue.poll();
    }
    
    private boolean isOperator(char c) {
        for (char o : operators) {
            if (c == o) {
                return true;
            }
        }
        return false;
    }
    
    private long calc(long left, long right, char c) {
        switch (c) {
            case '+' :
                return left + right;        
            case '-' :
                return left - right;
            case '*' :
                return left * right;
        }
        
        return 0L;
    }
    
}