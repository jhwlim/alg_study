import java.util.ArrayList;
import java.util.List;

// 완전탐색 - 모의고사
// https://programmers.co.kr/learn/courses/30/lessons/42840
class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
			
		int tmp = 0;
		
		for (int i = 0; i < answers.length; i++) {
			tmp = answers[i];
			if (tmp == student1[i % student1.length]) cnt1++;
			if (tmp == student2[i % student2.length]) cnt2++;
			if (tmp == student3[i % student3.length]) cnt3++;
		}
		
		
		int max = cnt1;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		if (cnt2 > max) {
			max = cnt2;
			list.clear();
			list.add(2);
		} else if (cnt2 == max) {
			list.add(2);
		}
		
		if (cnt3 > max) {
			max = cnt3;
			list.clear();
			list.add(3);
		} else if (cnt3 == max) {
			list.add(3);
		}
//		System.out.println(list);
		
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		
		return result;
    }
}