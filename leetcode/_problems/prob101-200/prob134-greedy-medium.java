/*
	# 134. Gas Station
	- Difficulty : Medium
	- Related Topics : Greedy
	- Runtime : 56ms, Memory : 39MB
		→ Runtime is too much! need to be improved 
*/
class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {

		int[] afterTravel = new int[gas.length];
		int sum = 0;
		
		for (int i = 0; i < gas.length; i++) {
			afterTravel[i] = gas[i] - cost[i];
			sum += afterTravel[i];
		}
		if (sum < 0) {
			return -1;
		}
		
		for (int i = 0; i < afterTravel.length; i++) {
			if (afterTravel[i] < 0) {
				continue;
			}
			
			sum = 0;
			for (int j = 0; j < afterTravel.length; j++) {
				sum += afterTravel[(i+j) % afterTravel.length];
				if (sum < 0) {
					break;
				}
			}
			if (sum >= 0) {
				return i;
			}
		}
		
		return -1;
	}
}