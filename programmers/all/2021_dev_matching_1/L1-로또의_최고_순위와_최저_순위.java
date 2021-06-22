class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] numbers = new boolean[46];
        for (int i : win_nums) {
            numbers[i] = true;
        }
        
        int zeroCount = 0;
        int count = 0;
        for (int i : lottos) {
            if (i == 0) {
                zeroCount++;
            } else if (numbers[i]) {
                count++;
            }
        }
        
        return new int[]{getRank(count + zeroCount), getRank(count)};
    }
    
    private int getRank(int cnt) {
        return cnt >= 2 ? 7 - cnt : 6;
    }
}