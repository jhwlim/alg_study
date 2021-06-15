class Solution {
    public String solution(int[] numbers, String hand) {
        int[] left = new int[2];
        int[] right = new int[2];
            
        left[0] = 3;
        left[1] = 0;
        right[0] = 3;
        right[1] = 2;
        
        char h = Character.toUpperCase(hand.charAt(0));
        StringBuilder result = new StringBuilder();
        for (int n : numbers) {
            result.append(getHand(n, left, right, h));
        }
        
        return result.toString();
    }
    
    public char getHand(int number, int[] left, int[] right, char hand) {
        int m = 0;
        int n = 0;
        if (number == 0) {
            m = 3;
            n = 1;
        } else {
            m = number%3 == 0 ? number/3 - 1 : number/3;
            n = number%3 == 0 ? 2 : number%3-1;
        }
        
        if (n == 0) {
            moveHand(left, m, n);
            return 'L';
        } else if (n == 2) {
            moveHand(right, m, n);
            return 'R';
        } else {
            int leftDistance = getDistance(left, m, n);
            int rightDistance = getDistance(right, m, n);
            if (leftDistance == rightDistance) {
                if (hand == 'L') {
                    moveHand(left, m, n);
                } else {
                    moveHand(right, m, n);
                }
                return hand;
            } else if (leftDistance < rightDistance) {
                moveHand(left, m, n);
                return 'L';
            } else {
                moveHand(right, m, n);
                return 'R';
            }
        }
    }
    
    public void moveHand(int[] hand, int row, int col) {
        hand[0] = row;
        hand[1] = col;
    }
    
    public int getDistance(int[] hand, int row, int col) {
        return Math.abs(hand[0] - row) + Math.abs(hand[1] - col);
    }
}