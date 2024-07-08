import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M, N, day;
        boolean[][] visited;
        int[][] stash;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Point> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        stash = new int[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int m = 0; m < M; m++) {
                stash[n][m] = Integer.parseInt(st.nextToken());
                if (stash[n][m] == 1) {
                    queue.add(new Point(m, n));
                    visited[n][m] = true;
                }
            }
        }

        if (queue.size() == M * N) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }

        day = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            day++;
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int xx = p.x + dx[j];
                    int yy = p.y + dy[j];
                    if (xx >= 0 && yy >= 0 && xx < M && yy < N && !visited[yy][xx] && stash[yy][xx] == 0) {
                        queue.add(new Point(xx, yy));
                        stash[yy][xx] = 1;
                        visited[yy][xx] = true;
                    }
                }
            }
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (stash[n][m] == 0) {
                    bw.write("-1");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }

        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();
    }
}
