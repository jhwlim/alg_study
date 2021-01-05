import java.util.HashSet;
import java.util.Set;

// 완전탐색 - 소수 찾기
// https://programmers.co.kr/learn/courses/30/lessons/42839
class Solution {
    
    static Set<Integer> set = new HashSet<Integer>();
    
    public int solution(String numbers) {
        int[] arr = new int[numbers.length()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = numbers.charAt(i) - '0';
		}
		
		int[] result = new int[7];
		boolean[] bools = new boolean[7];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= result.length; i++) {
			recursion(arr, 0, i, sb, bools);
		}
		
		return set.size();
    }
    
    static void recursion(int[] arr, int depth, int len, StringBuilder sb, boolean[] bools) {
		if (depth == len) {
			int n = Integer.parseInt(sb.toString());
			if (isPrime(n)) set.add(n);
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!bools[i]) {
				if (depth == 0 && arr[i] == 0) continue;
				
				sb.append(arr[i]);
				bools[i] = true;
				
				recursion(arr, depth+1, len, sb, bools);
				
				sb.deleteCharAt(depth);
				bools[i] = false;
			}
		}
		
		return;
	}
	
	static boolean isPrime(int n) {
		if (n == 1 || n == 0) return false;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}
}