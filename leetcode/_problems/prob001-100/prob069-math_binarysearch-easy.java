/*
	# 69. Sqrt(x)
	- Difficulty : Easy
	- Related Topics : Math, Binary Search
	- Runtime : 1ms, Memory : 36.1MB 
    - Algorithm : Newton-Raphson Method
*/
class Solution {
    
    public int mySqrt(int x) {
        
        double iterN = x;
        
        for (int i = 0; i < 100; i++) {
            iterN = (iterN + x / iterN) / 2;  
        }
        
        return (int) iterN;
    }
}