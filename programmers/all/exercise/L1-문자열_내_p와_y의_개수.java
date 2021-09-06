class Solution {
    boolean solution(String s) {
        return s.toUpperCase().replaceAll("P", "").length() == s.toUpperCase().replaceAll("Y", "").length();
    }
}