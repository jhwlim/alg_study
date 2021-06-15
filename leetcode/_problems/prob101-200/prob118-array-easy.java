/*
    # 118. Pascal's Triangle
    - Difficulty : Easy
    - Related Topics : Array
    - Runtime : 0ms, Memory : 36.5MB 
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>(); 
        
        answer.add(Arrays.asList(new Integer[]{1}));    // n=1
        
        for (int i = 1; i < numRows; i++) {
            int size = i + 1;
            Integer[] arr = new Integer[size];
            
            arr[0] = 1;
            arr[size-1] = 1;
            
            for (int j = 1; j <= i/2; j++) {
                int num = answer.get(i-1).get(j-1) + answer.get(i-1).get(j);
                arr[j] = num;
                arr[arr.length-j-1] = num;
            }
            answer.add(Arrays.asList(arr));
        }
        
        return answer;
    }
    
}