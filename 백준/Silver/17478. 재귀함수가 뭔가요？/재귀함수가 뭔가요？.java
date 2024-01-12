import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void run() throws IOException {
        int num = Integer.parseInt(br.readLine());

        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursion(num, num);
        bw.flush();

        br.close();
        bw.close();
    }

    String script1 = "\"재귀함수가 뭔가요?\"\n";
    String script2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    String script3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    String script4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    String script5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    String script6 = "라고 답변하였지.\n";

    String[] scripts = { script1, script2, script3, script4, script6 };
    String[] resultScripts = { script1, script5, script6 };

    void recursion(int n, int num) throws IOException {
        if (n == 0) {
            for (String s: resultScripts) {
                for (int i = num - n; i > 0; i--) {
                    bw.write("____");
                }
                bw.write(s);
            }
        } else {
            for (int i = 0; i < scripts.length; i++) {
                if (i == 4) recursion(n-1, num);
                for (int j = num - n; j > 0; j--) {
                    bw.write("____");
                }
                bw.write(scripts[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
