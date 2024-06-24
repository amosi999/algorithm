import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N; // 컴퓨터의 수
        int M; // 연결되어 있는 쌍의 수
        boolean[] visited;
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        ArrayList<Integer>[] com = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            com[i] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            com[a].add(b);
            com[b].add(a);
        }

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i = 0; i < com[n].size(); i++) {
                int nn = com[n].get(i);
                if (!visited[nn]) {
                    visited[nn] = true;
                    queue.add(nn);
                    result++;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
