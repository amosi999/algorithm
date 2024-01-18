import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    HashMap<String, Integer> map;
    ArrayList<String> result = new ArrayList<>();

    int wordsNum = 0;
    int wordsLength = 0;

    void run() throws IOException {
        input();
        sort();
        print();
        bw.flush();
        br.close();
        bw.close();
    }

    void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        wordsNum = Integer.parseInt(st.nextToken());
        wordsLength = Integer.parseInt(st.nextToken());
        map = new HashMap<>(wordsNum);

        for (int i = 0; i < wordsNum; i++) {
            String input = br.readLine();
            if (input.length() < wordsLength) continue;
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
        while (max != 0) {
            ArrayList<String> list = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max == entry.getValue()) list.add(entry.getKey());
            }
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() > o2.length()) return -1;
                    else if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    } else return 1;
                }
            });
            if (!list.isEmpty()) result.addAll(list);
            max--;
        }
    }

    void print() throws IOException {
        for (String s: result) {
            bw.write(s + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }


}
