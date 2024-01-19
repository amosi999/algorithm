import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    ArrayList<Integer> list = new ArrayList<>();
    int result;

    void run() throws IOException {
        input();
        result = check();
        print();
    }

    void input() throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        Collections.reverse(list);
    }

    int check() {
        int result = -1;
        int A, B, C;
        for (int a = 0; a < list.size() - 2; a++) { // 제일 큰 변
            A = list.get(a);
            B = list.get(a+1);
            C = list.get(a+2);
            if (A < B + C) return A + B + C;
        }
        return result;
    }

    void print() throws IOException {
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }

}
