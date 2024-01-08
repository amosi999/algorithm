import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> allNan = new ArrayList<>();
        ArrayList<Integer> realNan = new ArrayList<>();
        int allSum = 0;

        for (int i = 0; i < 9; i++) {
            allNan.add(Integer.parseInt(br.readLine()));
            allSum += allNan.get(i);
        }

        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < allNan.size() - 1; i++) {
            for (int j = i + 1; j < allNan.size(); j++) {
                if ((allSum - allNan.get(i) - allNan.get(j)) == 100) {
                    index1 = i;
                    index2 = j;
                    break;
                }
            }
        }

        for (int n: allNan) {
            if (n == allNan.get(index1) || n == allNan.get(index2)) {
                continue;
            }
            realNan.add(n);
        }
        Collections.sort(realNan);

        for (int n: realNan) {
            bw.write(String.valueOf(n) + '\n');
        }

        bw.flush();
    }
}
