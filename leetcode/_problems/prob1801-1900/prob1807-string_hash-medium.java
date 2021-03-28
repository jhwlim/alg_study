/*
	# 1807. Evaluate the Bracket Pairs of a String
	- Difficulty : Medium
	- Related Topics : Hash Table, String
	- Runtime : 31ms, Memory : 79.7MB 
*/
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));    
        }
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                flag = true;
                start = i;
                continue;
            } else if (c == ')') {
                flag = false;
                String key = s.substring(start+1, i);
                String value = map.get(key);
                
                sb.append(value == null ? "?" : value);
                continue;
            }
            
            if (!flag) {
                sb.append(c);  
            } 
        }
        
        return sb.toString();
    }
}