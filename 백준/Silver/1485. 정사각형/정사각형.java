import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T;
    int[] xList;
    int[] yList;
    ArrayList<Double> lList;

    void run() throws IOException {
        T = Integer.parseInt(br.readLine());
        xList = new int[4];
        yList = new int[4];
        lList = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            // input
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                xList[i] = Integer.parseInt(st.nextToken());
                yList[i] = Integer.parseInt(st.nextToken());
            }
            lList.add(Math.sqrt(Math.pow(xList[0] - xList[1], 2) + Math.pow(yList[0] - yList[1], 2)));
            lList.add(Math.sqrt(Math.pow(xList[1] - xList[2], 2) + Math.pow(yList[1] - yList[2], 2)));
            lList.add(Math.sqrt(Math.pow(xList[2] - xList[3], 2) + Math.pow(yList[2] - yList[3], 2)));
            lList.add(Math.sqrt(Math.pow(xList[3] - xList[0], 2) + Math.pow(yList[3] - yList[0], 2)));
            lList.add(Math.sqrt(Math.pow(xList[0] - xList[2], 2) + Math.pow(yList[0] - yList[2], 2)));
            lList.add(Math.sqrt(Math.pow(xList[1] - xList[3], 2) + Math.pow(yList[1] - yList[3], 2)));
            Collections.sort(lList);

            // check
            int count1 = 1;
            int count2 = 1;
            double l = lList.remove(0);
            for (int i = 0; i < 3; i++) {
                if (l == lList.remove(0)) {
                    count1++;
                }
            }
            l = lList.remove(0);
            if (l == lList.remove(0)) {
                count2++;
            }
            if (count1 == 4 && count2 == 2) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
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
