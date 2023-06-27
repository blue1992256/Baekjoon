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
        String number = input[0];
        int arithmetic = Integer.parseInt(input[1]);

        long sum = 0;
        for (int i = number.length()-1; i >= 0; i--) {
            int value;
            char word = number.charAt(i);
            if ('0' <= word && word <= '9') {
                value = word - '0';
            } else {
                value = word - 'A' + 10;
            }

            sum += Math.pow(arithmetic, number.length()-i-1) * value;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}