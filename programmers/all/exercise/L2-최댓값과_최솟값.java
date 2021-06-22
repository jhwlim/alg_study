class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String str : strs) {
            int n = Integer.parseInt(str);
            min = Math.min(n, min);
            max = Math.max(n, max);
        }
        
        return min + " " + max;
    }
}