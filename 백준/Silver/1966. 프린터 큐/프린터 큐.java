import java.io.*;
import java.util.*;

class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListQueue<E> {

    // head는 tail.next
    private Node<E> tail;
    private int size;

    public LinkedListQueue() {
        this.tail = null;
        this.size = 0;
    }

    public boolean offer(E value) {
        Node<E> newNode = new Node<E>(value);
        if (isEmpty()) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E poll() {
        if (isEmpty()) {
            /* 에러 처리 */
            return null;
        } else {
            E tmp = tail.next.data;
            if (tail.next == tail) { // 원소가 하나뿐
                tail = null;
            } else { // 2개 이상의 원소
                tail.next = tail.next.next;
            }
            size--;
            return tmp;
        }
    }

    public E front() {
        if (isEmpty()) {
            /* 에러 처리 */
            return null;
        } else {
            return tail.next.data;
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(E data) {
        for (Node<E> x = tail.next; x != null; x = x.next) {
            if (data.equals(x.data)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        tail = null;
    }

    public int findWhere(E data) {
        int index = 0;
        for (Node<E> x = tail.next; x != null; x = x.next) {
            if (data.equals(x.data)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void shiftL() {
        tail = tail.next;
    }

    public void shiftR() {
        Node<E> tmp = null;
        for (Node<E> x = tail.next; x != null; x = x.next) {
            if (x.next.equals(tail)) {
                tmp = x;
                break;
            }
        }
        tail = tmp;
    }
}

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    LinkedListQueue<Integer> queue;
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;

    int C, N, M;

    void run() throws IOException {
        C = Integer.parseInt(br.readLine());

        for (int c = 0; c < C; c++) {
            // input
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st1.nextToken());
            M = Integer.parseInt(st1.nextToken());
            queue = new LinkedListQueue<>();
            map = new HashMap<>();
            list = new ArrayList<>();
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int n = 0; n < N; n++) {
                queue.offer(n);
                int impor = Integer.parseInt(st2.nextToken());
                map.put(n, impor);
                list.add(impor);
            }
            Collections.sort(list);
            Collections.reverse(list);

            int count = 0;
            while (!queue.isEmpty()) {
                int firstImpor = list.get(0);
                int nowNum = queue.front();
                int nowNumImpor = map.get(nowNum);

                if (firstImpor == nowNumImpor) {
                    count++;
                    int print = queue.poll();
                    list.remove(0);
                    if (print == M) {
                        bw.write(count + "\n");
                        break;
                    }
                } else {
                    queue.offer(queue.poll());
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();

    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }

}
