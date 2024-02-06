import java.io.*;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] array;
    double[] fix;

    void run() throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        array = new int[N];
        fix = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for (int n = 0; n < N; n++) {
            array[n] = Integer.parseInt(st.nextToken());
            if (array[n] > max) max = array[n];
        }

        // process
        for (int i = 0; i < array.length; i++) {
            fix[i] = ((double) array[i] / max) * 100;
        }
        double sum = 0;
        for (double d : fix) {
            sum += d;
        }
        double avg = (double) sum / N;
        bw.write(String.valueOf(avg));

        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
