/*
	# 49. Group Anagrams
	- Difficulty : Medium
	- Related Topics : Hash Table, String
	- Runtime : 5ms, Memory : 41.6MB 
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            
            String key = new String(arr);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
            }
            
            list.add(str);
            map.put(key, list);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        
        return result;
    }
}