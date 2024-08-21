import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, X;
        int[] array1, array2;

        N = Integer.parseInt(br.readLine());
        array1 = new int[N];
        array2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            String str = st.nextToken();
            array1[i] = Integer.parseInt(str);
            array2[i] = Integer.parseInt(str);
        }
        X = Integer.parseInt(br.readLine());
        Arrays.sort(array2);

        int target;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += binarySearch(array2, array1[i], X);
        }

        bw.write(String.valueOf(cnt / 2));
        bw.flush();
        bw.close();
    }

    static int binarySearch(int[] arr, int target, int X) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target + arr[mid] == X && target != arr[mid]) {
                return 1;
            }

            if (target + arr[mid] <= X) {
                left = mid + 1;
            } else if (target + arr[mid] > X) {
                right = mid - 1;
            }

        }
        return 0;
    }
}
