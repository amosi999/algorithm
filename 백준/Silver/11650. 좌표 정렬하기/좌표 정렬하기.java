import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Dot implements Comparable<Dot> {
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Dot o) {
        if (this.x > o.x) {
            return 1;
        } else if (this.x < o.x) {
            return -1;
        } else {
            if (this.y > o.y) {
                return 1;
            } else if (this.y < o.y) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    ArrayList<Dot> dots;

    void run() throws IOException {
        input();
        Collections.sort(dots);
        print();
        br.close();
        bw.close();
    }

    void input() throws IOException {
        int n = Integer.parseInt(br.readLine());
        dots = new ArrayList<>();
        int x, y;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Dot d = new Dot(x, y);
            dots.add(d);
        }
    }

    void print() throws IOException {
        int x, y;
        for (Dot d: dots) {
            x = d.x;
            y = d.y;
            bw.write(String.valueOf(x + " " + y + "\n"));
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
