import java.util.*;

// 길이/너비 우선 탐색 > 여행경로
class Solution {
    public String[] solution(String[][] tickets) {

        Arrays.sort(tickets, new Comparator<String[]>() {

            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) {
                    return o1[1].compareTo(o2[1]);
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            }
        });

        String[] results = new String[tickets.length+1];
        boolean[] used = new boolean[tickets.length];
        String start = "ICN";

        doRecursion(tickets, results, used, start, 0);
        isFinished = true;

        return results;
    }

    boolean isFinished = false;

    public void doRecursion(String[][] tickets, String[] results, boolean[] used, String present, int depth) {
        if (isFinished) {
            return;
        }

        if (depth == results.length-1) {
            results[depth] = present;
            isFinished = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && present.equals(tickets[i][0])) {
                used[i] = true;
                results[depth] = tickets[i][0];
                doRecursion(tickets, results, used, tickets[i][1], depth+1);
                used[i] = false;
            }    
        }
    }

}
