/*
	# 121. Best Time to Buy and Sell Stock
	- Difficulty : Easy
	- Related Topics : Dynamic Programming, Array
	- Runtime : 2ms, Memory : 52MB 
*/
class Solution {
    public int maxProfit(int[] prices) {
		
        int maxProfit = 0;
        
		int min = Integer.MAX_VALUE;
		int max = 0;
		int p = 0;
        
		for (int i = 0; i < prices.length; i++) {
			p = prices[i];
			
			if (p < min) {
				maxProfit = Math.max(max-min, maxProfit);
                min = p;
				max = 0;
			}
            
			max = Math.max(p, max);
            
            if (i == prices.length-1) {
                maxProfit = Math.max(max-min, maxProfit);
            }
		}
        
		return maxProfit;
	}
}