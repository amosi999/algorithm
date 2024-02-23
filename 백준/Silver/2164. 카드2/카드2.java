import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N;
    Queue<Integer> queue;
    int result;

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();
        for (int n = 1; n <= N; n++) {
            queue.add(n);
        }

        while (true) {
            result = queue.poll();
            if (queue.isEmpty()) break;
            queue.add(queue.poll());
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.solution();
    }
}
