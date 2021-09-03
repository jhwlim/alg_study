/*
	# 125. Valid Palindrome
	- Difficulty : Easy
	- Related Topics : String, Two Pointers
	- Runtime : 4ms, Memory : 40.8MB
*/
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        
        int left = 0;
        int right = s.length()-1;    
    
        while(left < right) {
            if (!isAlphaNumeric(s.charAt(left))) {
                left++;
                continue;
            }   
            
            if (!isAlphaNumeric(s.charAt(right))) {
                right--;
                continue;
            }
            
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isAlphaNumeric(char c) {
        return ((c >= 'A' && c <= 'Z')
                || (c >= 'a' && c <= 'z')
                || (c >= '0' && c <= '9'));
    }
}