/*
	# 7. Reverse Integer
	- Difficulty : Easy
	- Related Topics : Math
*/
class Solution {
    public int reverse(int x) {
		long num = x;
		long reversedNum = 0;
		StringBuilder sb = null;
		
		if (x > 0) {
			sb = new StringBuilder(String.valueOf(x));
			sb = sb.reverse();
			reversedNum = Long.parseLong(sb.toString());
		} else if (x < 0) {
			num *= -1;
			sb = new StringBuilder(String.valueOf(num));
			sb = sb.reverse();
			reversedNum = Long.parseLong(sb.toString()) * (-1);
		} else {
			return 0;
		}
		
		if (!isOutOfRangeInteger(reversedNum)) {
			return Integer.parseInt(String.valueOf(reversedNum));
		} else {
			return 0;
		}
		
	}
	
	public boolean isOutOfRangeInteger(long n) {
		return n > Integer.MAX_VALUE || n < Integer.MIN_VALUE ? true : false;
	}
}