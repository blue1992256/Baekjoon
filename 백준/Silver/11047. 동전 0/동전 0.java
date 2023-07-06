import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] set = br.readLine().split(" ");
        int N = Integer.parseInt(set[0]);
        int K = Integer.parseInt(set[1]);
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        while (K != 0) {
            for (int i = N-1; i >=0; i--) {
                if (K % coins[i] != K) {
                    count += K / coins[i];
                    K = K % coins[i];
                }
                if (K == 0) {
                    break;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}