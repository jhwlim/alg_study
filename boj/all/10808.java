import java.io.*;

// #10808. 알파벳 개수
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int[] counts = new int[26];
        for (char c : input.toCharArray()) {
            counts[c - 'a']++;
        }

        StringBuilder output = new StringBuilder();
        for (int i : counts) {
            output.append(i + " ");
        }

        bw.write(output.toString().trim());
        bw.flush();
        bw.close();
    }
}