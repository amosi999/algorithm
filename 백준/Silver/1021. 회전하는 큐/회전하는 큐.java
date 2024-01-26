import java.io.*;
import java.util.Queue;
import java.util.StringTokenizer;

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

    int N, M;
    int[] target;
    int result;

    void run() throws IOException {
        // input
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        target = new int[M];
        // 초기 위치를 알아보기 위해 초기값 넣어줌
        for (int n = 0; n < N; n++) {
            queue.offer(n+1);
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int m = 0; m < M; m++) {
            target[m] = Integer.parseInt(st2.nextToken());
        }

        // 구현한 LinkedListQueue의 기능
        // offer, poll, front, isEmpty, size, contains, clear, findWhere, shiftL, shiftR
        result = 0;
        for (int t: target) {
            int tIndex = queue.findWhere(t);
            if (tIndex <= queue.size()/2) {
                while (queue.front() != t) {
                    queue.shiftL();
                    result++;
                }
                queue.poll();
            } else {
                while (queue.front() != t) {
                    queue.shiftR();
                    result++;
                }
                queue.poll();
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
        
    }

    public static void main(String[] args) throws IOException {
        Main my = new Main();
        my.run();
    }
}
