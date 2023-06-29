import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int recursion_cnt = 0;
    static int dynamic_cnt = 0;
    static int[] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        cache = new int[n+1];

        fib_recursion(n);
        fib_dynamic(n);

        bw.write(recursion_cnt + " " + dynamic_cnt);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int fib_recursion(int n) {
        if (n == 1 || n == 2) {
            recursion_cnt++;
            return 1;
        }
        return fib_recursion(n-1) + fib_recursion(n-2);
    }

    private static int fib_dynamic(int n) {
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) {
            dynamic_cnt++;
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

}