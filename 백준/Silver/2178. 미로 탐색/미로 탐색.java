import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N, M;
    int[][] maze;
    int[][] dist;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    Queue<String> queue = new LinkedList<>();


    void run() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        dist = new int[N][M];
        for (int n = 0; n < N; n++) {
            char[] c = br.readLine().toCharArray();
            for (int m = 0; m < c.length; m++) {
                maze[n][m] = c[m] - 48;
            }
        }

        queue.add("0 0");
        dist[0][0] = 1;

        bfs();

        bw.write(String.valueOf(dist[N - 1][M - 1]));
        bw.flush();
        bw.close();
    }

    int x, y;
    void bfs() {
        while (!queue.isEmpty()) {
            StringTokenizer st = new StringTokenizer(queue.poll(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int xx, yy;
            for (int i = 0; i < 4; i++) {
                xx = x + dx[i];
                yy = y + dy[i];
                if (xx >= 0 && xx < M && yy >= 0 && yy < N && maze[yy][xx] == 1) {
                    if (dist[yy][xx] == 0) {
                        dist[yy][xx] = dist[y][x] + 1;
                        queue.add(xx + " " + yy);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
