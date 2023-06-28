import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] set = br.readLine().split(" ");
        BigInteger b1 =  new BigInteger(set[0]);
        BigInteger b2 =  new BigInteger(set[1]);

        bw.write(b1.add(b2).toString());
        bw.flush();
        bw.close();
        br.close();
    }
}