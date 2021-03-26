import java.util.*;

// 2019 카카오 개발자 겨울 인턴십 > 튜플, lv2
class Solution {
    public int[] solution(String s) {
        s = s.substring(0, s.length()-1);
        
        List<int[]> list = new ArrayList<>();
        int left = 0;
        int size = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                left = i;
            } else if (s.charAt(i) == '}') {
                String tuple = s.substring(left+1, i);
                
                String[] strs = tuple.split(",");
                int[] element = new int[strs.length];
                for (int j = 0; j < strs.length; j++) {
                    element[j] = Integer.parseInt(strs[j]);
                }
                Arrays.sort(element);
                
                if (strs.length > size) {
                    size = strs.length;
                }
                
                list.add(element);
            }
        }
        
        // 배열의 길이 순으로 정렬
        Collections.sort(list, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] s1, int[] s2) {
                return s1.length - s2.length;
            }
        });
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = list.get(i)[0];
                continue;
            }
            
            result[i] = findDiffElement(list.get(i-1), list.get(i));
        }
        
        return result;
    }
    
    private int findDiffElement(int[] e1, int[] e2) {
        
        for (int i = 0; i < e1.length; i++) {
            if (e1[i] != e2[i]) {
                return e2[i];
            }
        }
        
        return e2[e2.length-1];
    }
}