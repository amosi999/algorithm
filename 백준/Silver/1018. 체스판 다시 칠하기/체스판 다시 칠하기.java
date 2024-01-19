import java.io.*;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] board;
    int N, M;
    int nMax, mMax;
    Integer[][] allCase;

    void run() throws IOException {
        input();
        makeCase();
        print();
        bw.flush();
        br.close();
        bw.close();
    }

    void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }
        nMax = N - 8;
        mMax = M - 8;
        allCase = new Integer[nMax+1][mMax+1];
    }

    void makeCase() {
        for (int i = 0; i <= nMax; i++) {
            for (int j = 0; j <= mMax; j++) {
                StringBuilder evenLine = new StringBuilder();
                StringBuilder oddLine = new StringBuilder();
                for (int ii = i; ii <= i + 7; ii++) {
                    String str = board[ii].substring(j, j + 8);
                    if (ii % 2 == 0) evenLine.append(str);
                    else oddLine.append(str);
                }
                int wStart = 0; int bStart = 0;
                char[] evenList = evenLine.toString().toCharArray();
                char[] oddList = oddLine.toString().toCharArray();
                for (int x = 0; x < evenList.length; x++) { // 왼쪽 맨위가 W인 경우
                    if (x % 2 == 0) {
                        if (!(evenList[x] == 'W')) wStart++;
                        if (!(oddList[x] == 'B')) wStart++;
                    } else {
                        if (!(evenList[x] == 'B')) wStart++;
                        if (!(oddList[x] == 'W')) wStart++;
                    }
                }
                for (int x = 0; x < evenList.length; x++) { // 왼쪽 맨위가 B인 경우
                    if (x % 2 == 0) {
                        if (!(evenList[x] == 'B')) bStart++;
                        if (!(oddList[x] == 'W')) bStart++;
                    } else {
                        if (!(evenList[x] == 'W')) bStart++;
                        if (!(oddList[x] == 'B')) bStart++;
                    }
                }
                allCase[i][j] = Math.min(wStart, bStart);
            }
        }
    }

    void print() throws IOException {
        int min = 64;
        for (int i = 0; i <= nMax; i++) {
            for (int j = 0; j <= mMax; j++) {
                if (min > allCase[i][j]) min = allCase[i][j];
            }
        }
        bw.write(String.valueOf(min));
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
