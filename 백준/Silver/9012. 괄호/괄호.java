import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int num;
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> result = new ArrayList<>();

    void run() throws IOException {
        input();
        check();
        print();
    }

    void input() throws IOException {
        num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            list.add(br.readLine());
        }
    }

    void check() {
        int check;
        for (int i = 0; i < list.size(); i++) {
            check = 0; // 왼쪽 괄호가 나오면 +1, 오른쪽 괄호가 나오면 -1
            char[] chars = list.get(i).toCharArray();
            for (char c: chars) {
                if (check < 0) break;
                if (c == '(') check++;
                else if (c == ')') check--;
            }
            if (check == 0) result.add("YES");
            else result.add("NO");
        }
    }

    void print() throws IOException {
        for (String str: result) {
            bw.write(str + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
