// Summer/Winter Coding(~2018) > 스킬트리, lv2
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int cnt = 0;
            
        for (String skillTree : skill_trees) {
            int idx = 0;
            int i = 0;
            
            for (; i < skillTree.length(); i++) {
                char c = skillTree.charAt(i);
                int tmp = skill.indexOf(c);
                
                if (tmp >= 0) {
                    if (tmp == idx) {
                        idx++;
                    } else if (tmp > idx) {
                        break;
                    }
                }
            }
            if (i == skillTree.length()) {
                cnt++;    
            }
        }
        
        return cnt;
    }
}