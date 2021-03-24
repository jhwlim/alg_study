class Solution {
    public int solution(String s) {
        int min = s.length();
        for (int i = 1; i < s.length(); i++) {
            int result = sol(s, i);

            min = min > result ? result : min;
        }
        return min;
    }
    
    public static int sol(String s, int len) {
		
		StringBuilder sb = new StringBuilder();
		String str = null;
		String compStr = null;
		int cnt = 1;
		
		for (int i = 0;; i += len) {
			if (i + len > s.length()) {
				if (cnt > 1) {
					sb.append(cnt);
				}
				sb.append(compStr);
				sb.append(s.substring(i));
				break;
			}
			str = s.substring(i, i + len);
			if (i == 0) {
				compStr = str;
				continue;
			} else {
				if (str.equals(compStr)) {
					cnt++;
					continue;
				} else {
					if (cnt > 1) {
						sb.append(cnt);
					}
					sb.append(compStr);
					compStr = str;
					cnt = 1;
					continue;
				}
			}
		}
		
		return sb.length();
	}


}