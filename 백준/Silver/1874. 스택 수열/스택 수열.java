import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb;
    int n;
    Stack<Integer> stack; // 1부터 n까지 내림차순으로 들어있는 스택(하나씩 뽑아서 사용)
    ArrayList<Integer> result;
    Stack<Integer> st;
    ArrayList<Integer> series; // 원하는 수열

    void run() throws IOException {
        // init
        stack = new Stack<>();
        result = new ArrayList<>();
        st = new Stack<>();
        series = new ArrayList<>();

        // input
        n = Integer.parseInt(br.readLine());
        for (int i = n; i >= 1; i--) {
            stack.push(i);
            series.add(Integer.parseInt(br.readLine()));
        }

        // process
        sb = new StringBuilder();
        int now;
        try {
            while (!series.isEmpty()) {
                now = series.remove(0);
                while (st.isEmpty() || st.peek() != now) {
                    st.push(stack.pop());
                    sb.append("+\n");
                }
                result.add(st.pop());
                sb.append("-\n");
            }
        } catch (Exception e) {
            sb.setLength(0);
            sb.append("NO");
        }
        
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
