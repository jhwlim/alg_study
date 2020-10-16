// 완전탐색 - 카펫
// https://programmers.co.kr/learn/courses/30/lessons/42842
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; // 0 : width, 1 : height
		
		for (int i = 1; i <= Math.sqrt(yellow); i++) {
			if (yellow % i == 0) {
				if (findBrownNum(yellow/i, i) == brown) {
					answer[0] = yellow / i + 2;
					answer[1] = i + 2;
					break;
				}
			}
		}
		
		return answer;
    }
    
    public int findBrownNum(int width, int height) {
		return (width + height) * 2 + 4;
	}
}