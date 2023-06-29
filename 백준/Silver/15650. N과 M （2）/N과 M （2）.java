import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] set = br.readLine().split(" ");
        n = Integer.parseInt(set[0]);
        m = Integer.parseInt(set[1]);
        isUsed = new boolean[n+1];
        arr = new int[m];

        recursion(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void recursion(int idx) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[idx] = i;
                recursion(idx+1);
                for (int j = i+1; j <= n; j++) {
                    isUsed[j] = false;
                }
            }
        }
    }
}