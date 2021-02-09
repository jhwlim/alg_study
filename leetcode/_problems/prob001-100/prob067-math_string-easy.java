/*
	# 67. Add Binary
	- Difficulty : Easy
	- Related Topics : Math, String
	- Runtime : 2ms, Memory : 37.7MB
*/
class Solution {
    public String addBinary(String a, String b) {
        
        int idxOfA = a.length()-1;
        int idxOfB = b.length()-1;
        
        StringBuilder result = new StringBuilder();
        
        int tmp = 0;
        int add = 0;
        
        int numOfA = 0;
        int numOfB = 0;
        
        while(idxOfA >= 0 || idxOfB >= 0 || add > 0) {
            numOfA = idxOfA >= 0 ? a.charAt(idxOfA--) - '0' : 0;
            numOfB = idxOfB >= 0 ? b.charAt(idxOfB--) - '0' : 0;
            
            tmp = numOfA + numOfB + add;
            
            if (tmp > 1) {
                add = 1;
                tmp -= 2;
            } else {
                add = 0;
            }
            result.append(tmp);
        }
        
        return result.reverse().toString();
    }
}