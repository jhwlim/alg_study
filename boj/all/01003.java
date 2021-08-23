import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// # 1003. 피보나치 함수
public class Main {
    
    private static int[][] arr;
    
    static {
        arr = new int[41][2];
        arr[0][0] = 1;
        arr[1][1] = 1;
        
        for (int i = 2; i < arr.length; i++) {
            arr[i][0] = arr[i-2][0] + arr[i-1][0];
            arr[i][1] = arr[i-2][1] + arr[i-1][1];
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(String.format("%d %d\n", arr[n][0], arr[n][1]));
        }
        
        bw.flush();
        bw.close();
    }
    
}
