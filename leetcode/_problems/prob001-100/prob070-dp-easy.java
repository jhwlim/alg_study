/*
	# 70. Climbing Stairs
	- Difficulty : Easy
	- Related Topics : Dynamic Programming
	- Runtime : 3ms, Memory : 35.9MB 
	- Other Idea : An = An-1 + An-2
*/
import java.math.BigInteger;

class Solution {
    public int climbStairs(int n) {
        
        int a = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int b = n / 2;
        
        int result = 0;
        while (b >= 0) {
            result += getCombination(a++, b--);
        }
        
        return result;
    }
    
    public static List<BigInteger> factorials = new ArrayList<>();
    
    static {
        factorials.add(new BigInteger("1"));
        for (int i = 1; i < 46; i++) {
            factorials.add(factorials.get(i-1).multiply(BigInteger.valueOf(i)));
        }
    }
    
    public int getCombination(int a, int b) {
        return factorials.get(a).divide(factorials.get(b).multiply(factorials.get(a-b))).intValue();
    }
}