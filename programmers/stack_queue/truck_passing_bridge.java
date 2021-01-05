import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> before = new LinkedList<Integer>();

        int cnt = 0;
        int time = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            before.add(truck_weights[i]);
        }

        int nowWeight = 0;
        Queue<Integer> passing = new LinkedList<Integer>();
        int[] timeArr = new int[truck_weights.length];

        while(cnt < truck_weights.length) {
            for (int i = cnt; i < cnt + passing.size(); i++) {
                timeArr[i]++;
            }

            if (timeArr[cnt] == bridge_length) {
                int truck = passing.poll();
                nowWeight -= truck;
                cnt++;
            }


            if (!before.isEmpty()) {
                if (passing.isEmpty()) {
                    int truck = before.poll();
                    passing.add(truck);
                    nowWeight += truck;
                    time++;

                    continue;
                }
                if (nowWeight + before.peek() <= weight) {
                    int truck = before.poll();
                    passing.add(truck);
                    nowWeight += truck; 
                } 
            }

            time++;

        }

        return time;

    }
}