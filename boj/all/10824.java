import java.io.*;

// #10824. 네 수
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");
        long result = Long.parseLong(strs[0] + strs[1]) + Long.parseLong(strs[2] + strs[3]);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

}