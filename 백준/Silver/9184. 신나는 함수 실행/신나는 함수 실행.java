import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[][][] cache = new int[101][101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] set = br.readLine().split(" ");
            int a = Integer.parseInt(set[0]);
            int b = Integer.parseInt(set[1]);
            int c = Integer.parseInt(set[2]);
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            int ans = recursion(a, b, c);
            sb.append(toString(a, b, c, ans));
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int recursion(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            if (cache[a+50][b+50][c+50] == 0) {
                cache[a+50][b+50][c+50] = 1;
                return 1;
            }
            return cache[a+50][b+50][c+50];
        }

        if (a > 20 || b > 20 || c > 20) {
            if (cache[a+50][b+50][c+50] == 0) {
                int ans = recursion(20, 20, 20);
                cache[a+50][b+50][c+50] = ans;
                return ans;
            }
            return cache[a+50][b+50][c+50];
        }

        if (a < b && b < c) {
            if (cache[a+50][b+50][c+50] == 0) {
                int ans = recursion(a, b, c-1) + recursion(a, b-1, c-1) - recursion(a, b-1, c);
                cache[a+50][b+50][c+50] = ans;
                return ans;
            }
            return cache[a+50][b+50][c+50];
        }

        if (cache[a+50][b+50][c+50] == 0) {
            int ans = recursion(a-1, b, c) + recursion(a-1, b-1, c) + recursion(a-1, b, c-1) - recursion(a-1, b-1, c-1);
            cache[a+50][b+50][c+50] = ans;
            return ans;
        }
        return cache[a+50][b+50][c+50];
    }

    private static String toString(int a, int b, int c, int ans) {
        StringBuilder sb = new StringBuilder();
        sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(ans).append("\n");
        return sb.toString();
    }
}