import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] step = new int[301];
        int[] score = new int[301];
        for (int i = 1; i <= n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        score[1] = step[1];
        score[2] = step[1] + step[2];
        score[3] = Math.max(step[1], step[2]) + step[3];

        for (int i = 4; i <= n; i++) {
            score[i] = Math.max(score[i-3] + step[i-1], score[i-2]) + step[i];
        }

        bw.write(String.valueOf(score[n]));

        bw.flush();

        br.close();
        bw.close();
    }
}
