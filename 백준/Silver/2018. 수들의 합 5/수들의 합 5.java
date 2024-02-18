import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N;
    int[] array;
    int sum;
    int count;
    int start, end;

    void run() throws IOException {
        N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        start = 1;
        end = 1;
        for (int n = 1; n <= N; n++) {
            array[n] = n;
        }
        sum = 1;
        count = 1;

        while (end != N) {
            if (sum > N) {
                sum -= start;
                start++;
            } else if (sum < N) {
                end++;
                sum += end;
            } else {
                end++;
                sum += end;
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
