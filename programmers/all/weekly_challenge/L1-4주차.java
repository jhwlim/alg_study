class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        
        String[][] scores = new String[5][5];
        
        for (int i = 0; i < table.length; i++) {
            scores[i] = table[i].split(" ");
        }
        
        int max = 0;
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            int sum = 0;
            for (int j = 0; j < languages.length; j++) {
                sum += getScore(scores[i], languages[j]) * preference[j];
            }
            
            if (sum > max) {
                max = sum;
                index = i;
            } else if (sum == max && scores[i][0].charAt(0) < scores[index][0].charAt(0)) {
                index = i;
            }
        }
        
        return scores[index][0];
    }
    
    private int getScore(String[] scores, String language) {
        for (int i = 1; i < scores.length; i++) {
            if (scores[i].equals(language)) {
                return 6-i;
            }
        }
        return 0;
    }
}