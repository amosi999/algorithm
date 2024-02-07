import java.io.*;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N, M;
    int[] A;
    int[] S;

    void run() throws IOException {
        // input
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        A = new int[N];
        S = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int n = 0; n < N; n++) {
            A[n] = Integer.parseInt(st2.nextToken());
            if (n == 0) S[n] = A[n];
            else S[n] = S[n - 1] + A[n];
        }

        // process
        int i, j, result;
        for (int m = 0; m < M; m++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
            i = Integer.parseInt(st3.nextToken()) - 1;
            j = Integer.parseInt(st3.nextToken()) - 1;
            if (i == 0) {
                result = S[j];
            } else {
                result = S[j] - S[i - 1];
            }
            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
