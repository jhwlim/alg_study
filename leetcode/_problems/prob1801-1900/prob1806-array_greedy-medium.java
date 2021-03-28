/*
	# 1806. Minimum Number of Operations to Reinitialize a Permutation
	- Difficulty : Medium
	- Related Topics : Array, Greedy
	- Runtime : 24ms, Memory : 35.5MB 
*/
class Solution {
    public int reinitializePermutation(int n) {
        int[] prevArr = new int[n];
        for (int i = 0; i < n; i++) {
            prevArr[i] = i;
        }
        int[] newArr = new int[n];
        int result = 0;
        for (;!isInitPerm(newArr); result++) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    newArr[i] = prevArr[i/2];
                } else {
                    newArr[i] = prevArr[n/2 + (i-1)/2];
                }
            }
            
            for (int i = 0; i < n; i++) {
                prevArr[i] = newArr[i];
            }
        }
        
        return result;
    }
    
    private boolean isInitPerm(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return false;
            } 
        }
        
        return true;
    }
}