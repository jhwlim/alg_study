class Solution {
    public String solution(int n) {
        return parse124(n);
    }

    public String parse124(int n) {
        final int scale = 3;

        StringBuilder sb = new StringBuilder();

        int add = 0;
        while (n != 0) {
            int r = n % scale + add;
            n = n / scale;

            if (n != 0 && r <= 0) {
                r += scale;
                add = -1;
            } else {
                add = 0;
            }

            if (r == 3) {
                r = 4;
            }
            sb.append(r);    
        }

        if (sb.charAt(sb.length()-1) == '0') {
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.reverse().toString();
    }
}
