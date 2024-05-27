import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T, N, M;

    void run() throws IOException {
        T = Integer.parseInt(br.readLine());

        String[] arr;
        Long result;
        for (int t = 0; t < T; t++) {
            arr = br.readLine().split(" ");
            N = Integer.parseInt(arr[0]);
            M = Integer.parseInt(arr[1]);
            if (M / 2 < N) N = M - N;
            result = combination(M, N);

            bw.write(String.valueOf(result) + "\n");
        }

        bw.flush();
        bw.close();
    }

    Long combination(int n, int r) {
        Long result = 1L;

        for (int i = n; i > n - r; i--) {
            result *= i;
        }
        for (int i = r; i > 0; i--) {
            result /= i;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
    
}
