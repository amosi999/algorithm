import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int five = 0;
        int three = 0;
        boolean isWork = true;

        while (true) {
            if (input == 0) break;
            if (input > 5) {
                if (((input % 5) % 3) == 0) {
                    int i = input / 5;
                    input -= 5 * i;
                    five += i;
                } else {
                    int i = input / 5;
                    for (int j = i-1; j >= 0; j--) {
                        if (((input - (j * 5)) % 3) == 0) {
                            input -= j * 5;
                            five += j;
                            int s = input / 3;
                            input -= s * 3;
                            three += s;
                            break;
                        }
                    }
                    if (input == 0) break;
                    isWork = false;
                    break;
                }
            } else if (input == 5) {
                input -= 5;
                five++;
            } else if (input == 4) {
                isWork = false;
                break;
            } else if (input == 3) {
                input -= 3;
                three++;
            } else {
                isWork = false;
                break;
            }
        }

        int result = five + three;
        if (isWork) {
            bw.write(String.valueOf(result));
            bw.flush();
        } else {
            bw.write("-1");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
