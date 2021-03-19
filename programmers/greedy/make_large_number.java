// 탐욕법 > 큰 수 만들기
class Solution {
    public String solution(String number, int k) {
        int idx = 0;
        String str = number;
        StringBuilder sb = new StringBuilder();
        
        for (int i = number.length()-k; i > 0; i--) {
            idx = findMaxNumIndex(str, i);
            sb.append(str.charAt(idx));
            str = str.substring(idx + 1);
        }
        
        return sb.toString();
    }
    
    private int findMaxNumIndex(String number, int loc) {
        int max = 0;
        int idx = 0;
        int num = 0;
        
        for (int i = 0; i <= number.length() - loc; i++) {
            num = number.charAt(i) - '0';
            if (num > max) {
                max = num;
                idx = i;
            }
        }
        return idx;
    } 
    
}