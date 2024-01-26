import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[][] field;
    int T, M, N, K;
    int bugNum;
    boolean[][] visit;

    void run() throws IOException {
        T = Integer.parseInt(br.readLine());
        
        // 테스트 케이스 개수에 따른 시행
        for (int t = 0; t < T; t++) {
            // input
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st1.nextToken());
            N = Integer.parseInt(st1.nextToken());
            K = Integer.parseInt(st1.nextToken());
            field = new int[M][N];
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    field[m][n] = 0;
                }
            }
            for (int k = 0; k < K; k++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st3.nextToken());
                int y = Integer.parseInt(st3.nextToken());
                field[x][y] = 1;
            }

            // visit 배열 초기화
            visit = new boolean[M][N];
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    visit[m][n] = false;
                }
            }

            // 깊이 우선 탐색을 활용한 함수로 필요한 벌레 수 세기
            bugNum = 0;
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (visit[m][n] == false && field[m][n] == 1) {
                        DFS(m, n);
                        bugNum++;
                    }
                }
            }
            bw.write(bugNum + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    // 배추 뭉치가 몇개인지(지렁이가 몇마리 있으면 되는지) 세기
    // y부터 끝까지 들어갔다가 다시 나와서 다음 x로 가는 식으로..
    // 근데 이제 거슬러 올라가는것도 생각해야됨
    void DFS(int x, int y) throws IOException {
        if (visit[x][y]) return;
        visit[x][y] = true;

        if (y < field[x].length-1 && field[x][y+1] == 1 && !visit[x][y+1]) DFS(x, y+1);
        if (y > 0 && field[x][y-1] == 1 && !visit[x][y-1]) DFS(x, y-1);
        if (x < field.length-1 && field[x+1][y] == 1 && !visit[x+1][y]) DFS(x+1, y);
        if (x > 0 && field[x-1][y] == 1 && !visit[x-1][y]) DFS(x-1, y);
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
