/*
	# 6. ZigZag Conversion
	- Difficulty : Medium
	- Related Topics : String
	- Runtime : 5ms, Memory : 39.7MB
*/
class Solution {

	public String convert(String s, int numRows) {
		
		if (numRows == 1) {
			return s;
		}
		
		char[][] arr = new char[numRows][s.length() / (numRows-1) + 1];
		
		int idx = 0;
		int row = 0;
		int col = 0;
		
		while (true) {
			if (col % 2 != 1 || !(row == 0 || row == numRows-1)) {
				arr[row][col] = s.charAt(idx++);				
			}
			
			if (col % 2 == 1) {
				row--;
				if (row < 0) {
					row = 0;
					col++;
				}
			} else {
				row++;
				if (row >= numRows) {
					row = numRows-1;
					col++;
				}
			}
			
			if (idx == s.length()) {
				break;				
			}
		}
		
		StringBuilder result = new StringBuilder();
				
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != '\u0000') {
					result.append(arr[i][j]);
					
					if (result.length() == s.length()) {
						return result.toString();
					}
				}
			}
		}
		
		return result.toString();
	}
}