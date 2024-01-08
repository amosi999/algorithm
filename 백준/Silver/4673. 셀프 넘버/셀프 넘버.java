import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedHashSet<Integer> nonSelfSet = new LinkedHashSet<>();

        for (int n = 1; n <= 10000; n++) {
            int num = n;
            while (num <= 10000) {
                if (num != n) nonSelfSet.add(num);
                char[] cArr;
                String str = String.valueOf(num);
                cArr = str.toCharArray();
                for (char c : cArr) {
                    int j = (int)c - 48;
                    num += j;
                }
            }
        }

        /*for (int i: nonSelfSet) {
            System.out.println(i);
        }*/

        for (int i = 1; i <= 10000; i++) {
            if (nonSelfSet.contains(i)) continue;
            bw.write(String.valueOf(i) + '\n');
        }

        bw.flush();
    }
}
