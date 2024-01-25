import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int N, M, V;
    boolean[] visit;

    void run() throws IOException {
        input();
        Arrays.fill(visit, false);
        DFS(V);
        bw.write("\n");
        Arrays.fill(visit, false);
        BFS(V);
        print();
    }

    void input() throws IOException {
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        V = Integer.parseInt(st1.nextToken());
        visit = new boolean[N + 1];
        for (int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }
        int i, j;
        for (int m = 0; m < M; m++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            i = Integer.parseInt(st2.nextToken());
            j = Integer.parseInt(st2.nextToken());
            graph.get(i).add(j);
            graph.get(j).add(i);
        }
        for (ArrayList<Integer> l: graph) {
            Collections.sort(l);
        }
    }

    void DFS(int v) throws IOException {
        if (visit[v]) return;
        visit[v] = true;
        bw.write(String.valueOf(v) + " ");
        if (v >= graph.size() || graph.get(v) == null) {
            return;
        } else {
            for (int i = 0; i < graph.get(v).size(); i++) {
                DFS(graph.get(v).get(i));
            }
        }
    }

    void BFS(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visit[v] = true;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            bw.write(String.valueOf(n) + " ");
            for (int i: graph.get(n)) {
                if (!visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    void print() throws IOException {
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
