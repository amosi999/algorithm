import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N;
        int[][] map;
        boolean[][] visited;
        Queue<Point> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int n = 0; n < N; n++) {
            char[] array = br.readLine().toCharArray();
            for (int i = 0; i < array.length; i++) {
                map[n][i] = array[i] - '0';
            }
        }

        // 나눠진 덩어리를 빠짐없이 찾을 수 있게
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {

                // 한 개의 덩어리에서 bfs
                if (map[y][x] == 1 && !visited[y][x]) {
                    visited[y][x] = true;
                    queue.add(new Point(x, y));

                    int count = 0;
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        count++;

                        int xx, yy;
                        for (int i = 0; i < 4; i++) {
                            xx = p.x + dx[i];
                            yy = p.y + dy[i];
                            if (xx >= 0 && yy >= 0 && xx < N && yy < N && map[yy][xx] == 1 && !visited[yy][xx]) {
                                visited[yy][xx] = true;
                                queue.add(new Point(xx, yy));
                            }
                        }
                    }
                    result.add(count);
                }
            }
        }
        Collections.sort(result);

        bw.write(result.size() + "\n");
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
