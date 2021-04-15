// 2019 카카오 개발자 겨울 인턴십 > 멀쩡한 사각형, lv2
// - 테스트는 통과했지만, 유클리드 호제법을 이용하면 더 간단하게 풀이 가능
class Solution {

    public long solution(int w, int h) {
        int longer = Math.max(w, h);
        int smaller = Math.min(w, h);
        long answer = 0;

        for (int i = 0; i < smaller; i++) {
            double start = (double) i * longer / smaller;
            double next = (double) (i+1) * longer / smaller;

            int top = (int) Math.floor(start);
            int bottom = (int) Math.ceil(next);
            answer += longer - (bottom - top);
        }

        return answer;
    }

}