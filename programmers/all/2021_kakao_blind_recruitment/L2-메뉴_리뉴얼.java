import java.util.*;

class Solution {

    static int max = 0;

    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            char[] result = new char[course[i]];
            max = 0;

            for(String order : orders) {
                if (order.length() >= result.length) {
                    char[] arr = order.toCharArray();
                    Arrays.sort(arr);
                    insertMap(arr, map, result, 0, 0);
                }
            }

            if (max >= 2) {
                addList(map, list);
            }
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public void insertMap(char[] order, Map<String, Integer> map, char[] result, int start, int depth) {
        if (depth == result.length) {
            String key = new String(result);
            Integer cnt = map.get(key);
            if (cnt == null) {
                cnt = 0;
            }
            map.put(key, cnt + 1);
            if (cnt + 1 > max) {
                max = cnt + 1;
            }
            return;
        }

        if (order.length - start < result.length - depth) {
            return;
        }

        for (int i = start; i < order.length; i++) {
            result[depth] = order[i];
            insertMap(order, map, result, i+1, depth+1);    
        }

    }

    public void addList(Map<String, Integer> map, List<String> list) {
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
    }
}