import java.util.*;

class Solution {
    private Set<List<Integer>> cases = null;
        
    public int solution(String[][] relation) {
        cases = new HashSet<>();
        
        for (int i = 1; i <= relation[0].length; i++) {
            int[] result = new int[i];
            doRecursion(relation, result, 0, 0);
        }
        
        return cases.size();
    }
    
    private void doRecursion(String[][] relation, int[] result, int depth, int start) {
        if (depth == result.length) {
            if (!contains(result) && check(relation, result)) {
                List<Integer> list = new ArrayList<>();
                for (int i : result) {
                    list.add(i);
                }
                
                cases.add(list);    
            }
            return;
        }
        
        for (int i = start; i < relation[0].length; i++) {
            result[depth] = i;
            doRecursion(relation, result, depth+1, i+1);
        }
        
    }
    
    private boolean contains(int[] result) {
        for (List<Integer> list : cases) {
            int index = 0;
            for (int i : result) {
                if (i == list.get(index)) {
                    index++;
                    if (index == list.size()) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean check(String[][] relation, int[] result) {
        Set<String> set = new HashSet<>();
        for (String[] r : relation) {
            StringBuilder key = new StringBuilder();
            for (int i : result) {
                key.append(r[i] + " ");
            }
            set.add(key.toString());
        }
        
        return set.size() == relation.length;
    }
    
}