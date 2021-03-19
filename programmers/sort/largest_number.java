import java.util.*;

// 정렬 > 가장 큰 수
class Solution {
    public String solution(int[] numbers) {
        String[] strs = new String[numbers.length];
        boolean isZero = true;
        
        for (int i = 0; i < numbers.length; i++) {
            if (isZero && numbers[i] != 0) {
                isZero = false;
            }
            strs[i] = String.valueOf(numbers[i]);
        }
        if (isZero) {
            return "0";
        }
        
        Arrays.sort(strs, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1+o2) - Integer.parseInt(o2+o1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = strs.length-1; i >= 0; i--) {
            sb.append(strs[i]);
        }
        
        return sb.toString();
    }
}