import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int len = 0;

        for (int i = 0; i < record.length; i++) {
            String[] strs = record[i].split(" ");
            switch (strs[0]) {
                case "Enter" :
                    map.put(strs[1], strs[2]); 
                    len++;
                    break;
                case "Leave" :
                    len++;
                    break;
                case "Change" :
                    map.put(strs[1], strs[2]);  
                    break;
            }
        }

        String[] result = new String[len];
        int idx = 0;

        for (int i = 0; i < record.length; i++) {
            String[] strs = record[i].split(" ");

            switch (strs[0]) {
                case "Enter" :
                    result[idx++] = map.get(strs[1]) + "님이 들어왔습니다.";  
                    break;
                case "Leave" :
                    result[idx++] = map.get(strs[1]) + "님이 나갔습니다.";  
                    break;
                case "Change" :
                    break;
            }
        }

        return result;
    }
}