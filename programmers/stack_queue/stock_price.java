// 스택/큐 > 주식가격
//  - 스택/큐 사용 X
class Solution {
    public int[] solution(int[] prices) {

        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];    
            for (int j = i+1; j < prices.length; j++) {
                result[i] += 1;
                if (prices[j] < price) {
                    break;
                }
            }
        }

        return result;
    }
}