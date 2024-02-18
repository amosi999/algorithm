import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N, M;
    int[] array;
    int sum;
    int count;
    int start, end;

    void run() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int n = 0; n < N; n++) {
            array[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        start = 0;
        end = N - 1;
        sum = array[start] + array[end];
        count = 0;

        while (start < end) {
            if (sum > M) {
                end--;
                sum = array[start] + array[end];
            } else if (sum < M) {
                start++;
                sum = array[start] + array[end];
            } else {
                start++;
                end--;
                sum = array[start] + array[end];
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
