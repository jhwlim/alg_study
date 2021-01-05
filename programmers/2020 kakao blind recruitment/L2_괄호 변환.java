class Solution {
   public String solution(String p) {
        
		StringBuilder sb = new StringBuilder();
		
		int num = 0;
		int start = 0;
		int fin = 0;
		
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == cArr[0]) {
				num++;
			} else {
				num--;
			}
			
			if (i > 0 && num == 0) {
				fin = i + 1;
				if (isCorrect(p.substring(start, fin))) {
					sb.append(p.substring(start, fin));
				} else {
					String u = p.substring(start, fin);
					String v = p.substring(fin);
					
					String result = solution(v);
					String substrU = u.substring(1, u.length()-1).replace('(', '0').replace(')', '(').replace('0', ')');
					sb.append(cArr[0] + result + cArr[1] + substrU);
					break;
					
				}
				start = fin;
				
			}
			
		}
		
		
		return sb.toString();
    }
	
	public static char[] cArr = {
			'(', ')'
	};
	
	public static boolean isCorrect(String s) {
		int num = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == cArr[0]) {
				num++;
			} else {
				num--;
			}
			
			if (num < 0) {
				return false;
			}
		}
		
		return true;
	}
}