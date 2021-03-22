import java.util.*;

// 깊이/너비 우선 탐색 > 단어 변환
class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    private int bfs(String begin, String target, String[] words) {
        boolean isFind = false;
        boolean[] isVisited = new boolean[words.length];
        List<Integer> candidates = getIndexsOfCandidate(begin, words);

        Queue<Integer> q = new LinkedList<>();
        for (Integer i : candidates) {
            isVisited[i] = true;
            q.add(i);
            q.add(0);
        }

        int idx = 0;
        int depth = 0;
        while(!q.isEmpty()) {
            idx = q.poll();
            depth = q.poll();
            String word = words[idx];
            if (word.equals(target)) {
                isFind = true;
                break;
            }

            candidates = getIndexsOfCandidate(word, words);
            for (Integer i : candidates) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    q.add(i);
                    q.add(depth+1);
                }
            }
        }

        return isFind ? depth+1 : 0;
    }

    private List<Integer> getIndexsOfCandidate(String word, String[] words) {
        List<Integer> list = new ArrayList<>();

        for (int j = 0; j < words.length; j++) {
            String w = words[j];
            if (w.equals(word)) {
                continue;
            }

            for (int i = 0; i < w.length(); i++) {
                if (isEqualExceptionOneWord(word, w, i)) {
                    list.add(j);
                    break;
                }
            }
        }

        return list;
    }

    private boolean isEqualExceptionOneWord(String word1, String word2, int idx) {
        if (word1.length() != word2.length()) {
            return false;
        }

        boolean prefixChk = word1.substring(0, idx).equals(word2.substring(0, idx));
        boolean suffixChk = true;
        if (idx < word1.length()) {
            suffixChk = word1.substring(idx+1).equals(word2.substring(idx+1));
        }

        return prefixChk && suffixChk;
    }
}