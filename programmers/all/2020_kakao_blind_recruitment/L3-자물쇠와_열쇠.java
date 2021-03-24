class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        
		int size = lock.length;
		
		for (int rot = 0; rot < 4; rot++) {
			for (int i = 0 - key.length; i < size; i++) {
				for (int j = 0 - key.length; j < size; j++) {
					if (check(key, lock, j, i)) {
						return true;
					}
				}
			}
			key = rotationKey(key);
		}
		
		return false;
    }

	
	public int[][] rotationKey(int[][] key) {
		
		int size = key.length;
		int[][] rot = new int[size][size];
		
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				rot[j][size-1-i] = key[i][j];
			}
		}
		
		
		return rot;
	}
	
	public boolean check(int[][] key, int[][] lock, int x, int y) {
		
		int size = lock.length;
		int keyRow = 0;
		int keyCol = 0;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				keyRow = i - y;
				keyCol = j - x;
				
				if (keyRow < 0 || keyRow > key.length-1
						|| keyCol < 0 || keyCol > key.length-1) {
					if (lock[i][j] != 1) {
						return false;
					}
				} else {
					
					if (key[keyRow][keyCol] + lock[i][j] != 1) {
						return false;
					}
				}
				
			}
		}
		
		return true;
	}
}