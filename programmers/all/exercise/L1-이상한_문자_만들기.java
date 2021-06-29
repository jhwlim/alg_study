class Solution {
    public String solution(String s) {
        int wordIndex = 0;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                wordIndex = 0;
            } else {
                if (wordIndex % 2 == 0) {
                    if (c >= 'a' && c <= 'z') {
                        c += 'A' - 'a';
                    } 
                } 
                
                wordIndex++;
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}