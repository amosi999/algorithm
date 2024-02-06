import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void run() throws IOException {
        int N = Integer.parseInt(br.readLine()); // 안쓰는데.. 상관없겠지?
        char[] array = br.readLine().toCharArray();
        int sum = 0;
        for (char c : array) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
