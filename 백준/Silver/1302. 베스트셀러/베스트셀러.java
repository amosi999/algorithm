import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    HashMap<String, Integer> map;
    ArrayList<String> result = new ArrayList<>();

    int wordsNum = 0;

    void run() throws IOException {
        input();
        sort();
        print();
    }

    void input() throws IOException {
        wordsNum = Integer.parseInt(br.readLine());
        map = new HashMap<>(wordsNum);

        for (int i = 0; i < wordsNum; i++) {
            String input = br.readLine();
            if (!map.containsKey(input)) {
                map.put(input, 1);
            } else {
                int v = map.get(input);
                map.replace(input, v + 1);
            }
        }
    }

    void sort() {
        int max = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (max < entry.getValue()) max = entry.getValue();
        }
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) list.add(entry.getKey());
        }
        Collections.sort(list);
        if (!list.isEmpty()) result.addAll(list);
    }

    void print() throws IOException {
        bw.write(result.get(0));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
