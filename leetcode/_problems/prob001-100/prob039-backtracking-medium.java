/*
	# 39. Combination Sum
	- Difficulty : Medium
	- Related Topics : Array, Backtracking
	- Runtime : 3ms, Memory : 41.1MB
*/
class Solution {
    
    public static List<List<Integer>> combinations = null;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        List<Integer> result = new ArrayList<>();
        doRecursion(candidates, target, 0, result);
        
        return combinations;
    }
    
    public void doRecursion(int[] candidates, int target, int start, List<Integer> result) {
        if (target == 0) {
            combinations.add(new ArrayList<>(result));
            return;
        } 
            
        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            if (target-c < 0) {
                return;
            }
            
            result.add(c);
            doRecursion(candidates, target-c, i, result);
            result.remove(result.size()-1);
        }
        
    }
    
}