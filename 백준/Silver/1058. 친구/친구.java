import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, INF = 987654321, max = 0;
        int[][] dist;

        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];

        char[] chars;
        for (int n = 0; n < N; n++) {
            chars = br.readLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'Y') {
                    dist[n][i] = 1;
                    continue;
                }
                dist[n][i] = INF;
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int n;
        for (int i = 0; i < N; i++) {
            n = 0;
            for (int j = 0; j < N; j++) {
                if ((dist[i][j] == 1 || dist[i][j] == 2) && i != j) {
                    n++;
                }
            }
            max = Math.max(max, n);
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
    }
}
