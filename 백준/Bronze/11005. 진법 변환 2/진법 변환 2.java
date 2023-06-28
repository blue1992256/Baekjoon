import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);
        int arithmetic = Integer.parseInt(input[1]);

        String changedNum = "";
        while (true) {
            long remain = N % arithmetic;
            N = N / arithmetic;
            changedNum = arithmeticChanged(remain) + changedNum;
            if (N < arithmetic) {
                if (N == 0) {
                    break;
                }
                changedNum = arithmeticChanged(N) + changedNum;
                break;
            }
        }

        bw.write(changedNum);
        bw.flush();
        bw.close();
        br.close();
    }

    private static String arithmeticChanged(long num) {
        if (num <= 9) {
            return String.valueOf(num);
        }
        char chr = (char) ('A' + (num-10));
        return String.valueOf(chr);
    }
}