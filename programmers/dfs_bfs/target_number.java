// # 길이/너비 우선 탐색 > 타겟 넘버
class Solution {
    static int answer = 0;
	
    public int solution(int[] numbers, int target) {
        
        answer = 0;
        
        bf(numbers, target, 0, 0);
        
        return answer;
    }
	
    public void bf(int[] numbers, int target, int depth, int sum) {
    	if (depth == numbers.length) {
    		if (sum == target) {
    			answer++;
    		}
    		return;
    	}
    	
    	int num = numbers[depth];
    	for (int i = 0; i < 2; i++) {
    		if (i == 0) {
    			bf (numbers, target, depth+1, sum-num);
    		} else {
    			bf (numbers, target, depth+1, sum+num);
    		}
    		
    	}
    }
}