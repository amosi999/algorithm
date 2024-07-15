import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M, N, H, day;
        boolean[][][] visited;
        int[][][] stash;
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        Queue<Point> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new boolean[H][N][M];
        stash = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int m = 0; m < M; m++) {
                    stash[h][n][m] = Integer.parseInt(st.nextToken());
                    if (stash[h][n][m] == 1) {
                        queue.add(new Point(m, n, h));
                        visited[h][n][m] = true;
                    }
                }
            }
        }

        if (queue.size() == M * N * H) {
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
                for (int j = 0; j < 6; j++) {
                    int xx = p.x + dx[j];
                    int yy = p.y + dy[j];
                    int zz = p.z + dz[j];
                    if (xx >= 0 && yy >= 0 && zz >= 0 && xx < M && yy < N && zz < H
                            && !visited[zz][yy][xx] && stash[zz][yy][xx] == 0) {
                        queue.add(new Point(xx, yy, zz));
                        stash[zz][yy][xx] = 1;
                        visited[zz][yy][xx] = true;
                    }
                }
            }
        }

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (stash[h][n][m] == 0) {
                        bw.write("-1");
                        bw.flush();
                        bw.close();
                        return;
                    }
                }
            }
        }

        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();
    }
}
