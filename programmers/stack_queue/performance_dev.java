import java.util.Stack;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
		int n = 0;
		int cnt = 1;
		
		for (int i = 0; i < progresses.length; i++) {
			if (progresses[i] + speeds[i] * n < 100) {
				if (i > 0) {
					stack.push(cnt);
					cnt = 1;					
				}
				n = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
			} else {
				cnt++;
				continue;
			}
		}
		stack.push(cnt);
		
		int[] result = new int[stack.size()];
		
		for (int i = stack.size()-1; i >= 0; i--) {
			result[i] = stack.pop();
		}
		
		return result;
    }
}
