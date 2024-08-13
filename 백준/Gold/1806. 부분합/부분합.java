import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, S;
        int[] arr;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = -1;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int end = 0; end < N; end++) {
            sum += arr[end];
            while (sum >= S) {
                min = Math.min(min, end - start);
                sum -= arr[++start];
            }
        }

        if (min == Integer.MAX_VALUE) bw.write("0");
        else bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}
