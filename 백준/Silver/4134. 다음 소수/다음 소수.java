import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        ArrayList<Long> nList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Long a = Long.parseLong(br.readLine());
            nList.add(a);
        }

        for (Long start: nList) {
            for (long n = start; ; n++) {
                boolean isSosu = true;
                if (n < 2) continue;
                for (long i = 2L; i * i <= n; i++) {
                    if (n % i == 0) {
                        isSosu = false;
                        break;
                    }
                }
                if (isSosu) {
                    bw.write(String.valueOf(n) + '\n');
                    break;
                }
            }
        }

        bw.flush();
    }
}
