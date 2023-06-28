import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int standard = 3;

        double result;
        if (N != 1) {
            while (N-- > 1) {
                standard = 2 * standard - 1;
            }
        }
        result = Math.pow(standard, 2);

        bw.write(String.valueOf((long)result));
        bw.flush();
        bw.close();
        br.close();
    }
}
