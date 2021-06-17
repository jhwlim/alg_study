class Solution {
    public int solution(int n) {
        int givenCount = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c - '0' == 1) {
                givenCount++;
            }
        }
        
        for (int i = n+1; i <= 1000000; i++) {
            String bits = Integer.toBinaryString(i);
            int count = 0;
            for (char c : bits.toCharArray()) {
                if (c - '0' == 1) {
                    count++;
                }
            }
            if (count == givenCount) {
                return i;   
            }
        }
        
        return 0;
    }
    
}