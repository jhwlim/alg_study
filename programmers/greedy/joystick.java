import java.util.*;

// 탐욕법 > 조이스틱
class Solution {
    public int solution(String name) {

        int sum = 0;

        sum += findLeftRightCnt(name);
        System.out.println(sum);

        for (int i = 0; i < name.length(); i++) {
            sum += findTopDownCnt(name.charAt(i));
        }

        return sum;
    }

    static int[] moves;

    static {
        moves = new int[26];
        for (int i = 1; i <= 13; i++) {
            moves[i] = i;
            moves[26-i] = i;
        }
    }

    public static int findTopDownCnt(char c) {
        return moves[c - 'A'];
    }

    public static int findLeftRightCnt(String str) {
        int min = str.length()-1;
        char c = '0';
        int returnPoint = 0;
        boolean isA = false;

        for (int i = 1; i < str.length(); i++) {
            c = str.charAt(i);

            if (c == 'A') {
                if (!isA) {
                    isA = true;
                    returnPoint = i;
                }

            }

            if (c != 'A') {
                if (isA) {
                    isA = false;
                    min = Math.min(min, calcMoveCnt(str.length(), returnPoint, i-1));
                }
            }

            if (isA && i == str.length()-1) {
                min = Math.min(min, returnPoint-1);
            }

        }

        return min;
    }

    public static int calcMoveCnt(int len, int returnPoint, int finPoint) {
        return (returnPoint-1) * 2 + len - finPoint - 1;
    }
}