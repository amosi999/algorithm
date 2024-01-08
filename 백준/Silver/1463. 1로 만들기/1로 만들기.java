import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int[] dp = new int[input + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= input; i++) {
            if (dp[i] == 0) {
                if (i % 6 == 0) {
                    dp[i] = Math.min(dp[i-1], Math.min(dp[i/3], dp[i/2])) + 1;
                } else if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i-1], dp[i/3]) + 1;
                } else if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
                } else {
                    dp[i] = dp[i-1] + 1;
                }
            }
        }

        bw.write(String.valueOf(dp[input]));
        bw.flush();

        br.close();
        bw.close();
    }
}
