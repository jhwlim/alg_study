import java.io.*;

// #10820. 문자열 분석
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while ((input = br.readLine()) != null) { // EOF
            int[] counts = new int[4];

            for (char c : input.toCharArray()) {
                if (isLowerCase(c)) {
                    counts[0]++;
                } else if (isUpperCase(c)) {
                    counts[1]++;
                } else if (isNumber(c)) {
                    counts[2]++;
                } else {
                    counts[3]++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i : counts) {
                sb.append(i + " ");
            }

            bw.write(sb.toString().trim() + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isUpperCase(char c) {
        return c>= 'A' && c <= 'Z';
    }

    private static boolean isNumber(char c) {
        return c>= '0' && c <= '9';
    }

}
