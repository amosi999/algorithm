import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, root = 0, delete, result = 0;
        ArrayList<Integer>[] tree;
        boolean[] visited;

        // input
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        visited = new boolean[N];
        for (int n = 0; n < N; n++) {
            tree[n] = new ArrayList<>();
            visited[n] = false;
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            Integer n = Integer.parseInt(st.nextToken());
            if (n == -1) {
                root = i;
                continue;
            }
            tree[n].add(i);
        }
        delete = Integer.parseInt(br.readLine());

        // solution
        result = dfs(root, delete, tree, visited);

        // output
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static int dfs(int node, int delete, ArrayList<Integer>[] tree, boolean[] visited) {
        int temp = 0;
        if (visited[node] || node == delete) {
            return 0;
        }
        visited[node] = true;
        if (tree[node].isEmpty()) {
            return 1;
        } else if (tree[node].size() == 1 && tree[node].get(0) == delete) {
            return 1;
        } else {
            for (int i = 0; i < tree[node].size(); i++) {
                temp += dfs(tree[node].get(i), delete, tree, visited);
            }
            return temp;
        }
    }
}
