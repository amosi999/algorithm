import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> input = new ArrayList<>();
        Boolean[] isPrime;

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            input.add(n);
        }

        // init
        isPrime = new Boolean[246913];
        for (int i = 0; i < isPrime.length; i++) {
            if (i == 0 || i == 1) {
                isPrime[i] = false;
                continue;
            }
            isPrime[i] = true;
        }

        // solution
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int n : input) {
            int result = 0;
            for (int i = n + 1; i <= n * 2; i++) {
                if (isPrime[i]) {
                    result++;
                }
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}
