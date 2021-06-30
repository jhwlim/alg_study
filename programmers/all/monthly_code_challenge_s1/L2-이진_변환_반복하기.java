class Solution {

    public int[] solution(String s) {
        int loop = 0;
        int count = 0;
        while (!s.equals("1")) {
            int removedCount = countRemoved(s);
            count += removedCount;
            s = Integer.toBinaryString(s.length() - removedCount);
            loop++;
        }    
        return new int[]{loop, count};
    }

    private int countRemoved(String s) {
        return s.length() - s.replaceAll("0", "").length();
    }

}