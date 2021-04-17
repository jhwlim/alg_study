import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// # 1991. 트리 순회
public class Main {
    
    static char[][] nodes;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        nodes = new char[26][3];
        
        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            char c = strs[0].charAt(0);
            nodes[c - 'A'][0] = c;
            nodes[c - 'A'][1] = strs[1].charAt(0);
            nodes[c - 'A'][2] = strs[2].charAt(0);
        }
        
        StringBuilder sb = new StringBuilder();
        printByPreorder(nodes[0], sb);
        bw.write(sb.toString() + "\n");
        
        sb = new StringBuilder();
        printByInorder(nodes[0], sb);
        bw.write(sb.toString() + "\n");
        
        sb = new StringBuilder();
        printByPostorder(nodes[0], sb);
        bw.write(sb.toString() + "\n");
        
        bw.flush();
        bw.close();
    }
    
    public static void printByPreorder(char[] arr, StringBuilder sb) {
        sb.append(arr[0]);
        if (arr[1] != '.') {
            printByPreorder(nodes[arr[1] - 'A'], sb);
        }
        if (arr[2] != '.') {
            printByPreorder(nodes[arr[2] - 'A'], sb);	
        }
    }
    
    public static void printByInorder(char[] arr, StringBuilder sb) {
        if (arr[1] != '.') {
            printByInorder(nodes[arr[1] - 'A'], sb);
        }
        sb.append(arr[0]);
        if (arr[2] != '.') {
            printByInorder(nodes[arr[2] - 'A'], sb);	
        }
    }
    
    public static void printByPostorder(char[] arr, StringBuilder sb) {
        if (arr[1] != '.') {
            printByPostorder(nodes[arr[1] - 'A'], sb);
        }
        if (arr[2] != '.') {
            printByPostorder(nodes[arr[2] - 'A'], sb);	
        }
        sb.append(arr[0]);
    }
}
