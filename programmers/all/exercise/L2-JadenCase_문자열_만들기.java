class Solution {
    public String solution(String s) {
        StringBuilder tmp = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (tmp.length() > 0) {
                    sb.append(toJadenCase(tmp.toString()));
                    tmp.setLength(0);
                }
                sb.append(c);
            } else {
                tmp.append(c);
            }
        }
        if (tmp.length() > 0) {
            sb.append(toJadenCase(tmp.toString()));    
        }
        
        return sb.toString();
    }
    
    private String toJadenCase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
    
}