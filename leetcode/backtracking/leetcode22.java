// #22. Generate Parentheses : Medium
class Solution {
    
    static char[] arr = {'(', ')'};
        
    public List<String> generateParenthesis(int n){
    
        int lCnt = n;
        int rCnt = n;
        
        List<String> list = new ArrayList<>();
    
        StringBuilder sb = new StringBuilder();
        
        solution(lCnt, rCnt, 0, 2*n, sb, list);
        
        return list;
    }
    
    static void solution(int lCnt, int rCnt, int depth, int len, StringBuilder sb, List<String> list) {
        if (depth == len) {
            list.add(sb.toString());
            return;
        }
        
        if (lCnt == rCnt) {
            sb.append("(");
            solution(lCnt-1, rCnt, depth+1, len, sb, list);
            sb.deleteCharAt(depth);
            
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i == 0 && lCnt < 1) continue;
                
                sb.append(arr[i]);
                if (i == 0) solution(lCnt-1, rCnt, depth+1, len, sb, list);
                else solution(lCnt, rCnt-1, depth+1, len, sb, list);
                sb.deleteCharAt(depth);
            
            }
        }
                   
    }
}