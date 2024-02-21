import java.io.*;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int S, P;
    char[] DNA;
    int[] checkArr;
    int[] myArr;
    int check;
    int result;

    void solution() throws IOException {
        // input
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        DNA = str.toCharArray();
        st = new StringTokenizer(br.readLine(), " ");
        checkArr = new int[4];
        myArr = new int[4];
        check = 0;
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) check++;
        }

        for (int i = 0; i < P; i++) {
            add(DNA[i]);
        }
        if (check == 4) result++;

        for (int i = P; i < S; i++) {
            int j = i - P;
            add(DNA[i]);
            delete(DNA[j]);
            if (check == 4) result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    void add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) check++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) check++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) check++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) check++;
                break;
        }
    }

    void delete(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) check--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) check--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) check--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) check--;
                myArr[3]--;
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.solution();
    }

}
