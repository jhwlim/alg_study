/*
	# 1805. Number of Different Integers in a String
	- Difficulty : Easy
	- Related Topics : String
	- Runtime : 8ms, Memory : 39.2MB 
*/
class Solution {
    public int numDifferentIntegers(String word) {
        String regex = "[a-z]";
        String[] strs = word.split(regex);
        Set<String> set = new HashSet<>();
        
        for (String str : strs) {
            if (!str.trim().equals("")) {
                int i = 0;
                for (; i < str.length(); i++) {
                    if (str.charAt(i) != '0') {
                        break;
                    }
                }
                set.add(str.substring(i));        
            }
        }
        
        return set.size();
    }
}