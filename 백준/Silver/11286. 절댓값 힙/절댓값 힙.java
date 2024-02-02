import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Heap heap;
    int N;

    void run() throws IOException {
        // input
        N = Integer.parseInt(br.readLine());

        // init
        heap = new Heap(N);

        // process
        int x;
        for (int n = 0; n < N; n++) {
            x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (heap.isEmpty()) bw.write("0\n");
                else bw.write(heap.deleteMin() + "\n");
            } else {
                heap.insert(x);
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

    class Heap {
        private Integer[] A;
        private int numItems;

        public Heap(int arraySize) {
            A = new Integer[arraySize];
            numItems = 0;
        }
        public Heap(Integer[] B, int numElements) {
            A = B;
            numItems = numElements;
        }

        private void percolateUp(int i) {
            int parent = (i - 1) / 2;
            if (parent >= 0 && Math.abs(A[i]) < Math.abs(A[parent])) { // 현재 노드의 절댓값이 부모의 것보다 작으면 부모랑 바꿈
                Integer tmp = A[i];
                A[i] = A[parent];
                A[parent] = tmp;
                percolateUp(parent);
            } else if (parent >= 0 && Math.abs(A[i]) == Math.abs(A[parent])) { // 둘이 절댓값이 같으면
                if (A[i].compareTo(A[parent]) < 0) { // 현재 노드 값이 더 작을때 서로 바꿈
                    Integer tmp = A[i];
                    A[i] = A[parent];
                    A[parent] = tmp;
                    percolateUp(parent);
                } // 부모 노드 값이 더 작으면 그대로
            }
        }

        public void insert(Integer newItem){
            if (numItems < A.length) {
                A[numItems] = newItem;
                percolateUp(numItems);
                numItems++;
            }
        }

        private void percolateDown(int i) {
            int child = 2 * i + 1;
            int rightChild = 2 * i + 2;
            if (child <= numItems - 1) {
                if (rightChild <= numItems - 1 && Math.abs(A[child]) > Math.abs(A[rightChild])) {
                    // 왼쪽 자식의 절댓값이 오른쪽 자식의 절댓값보다 크면
                    child = rightChild;
                } else if (rightChild <= numItems - 1 && Math.abs(A[child]) == Math.abs(A[rightChild])) {
                    // 왼쪽 자식의 절댓값과 오른쪽 자식의 절댓값이 같으면
                    if (A[child].compareTo(A[rightChild]) > 0) { // 왼쪽 자식의 값이 오른쪽 자식의 값보다 클때
                        child = rightChild;
                    } // 왼쪽 자식이 더 작으면 그대로
                }
                if (Math.abs(A[i]) > Math.abs(A[child])) { // 현재 노드의 절댓값이 자식 노드 중 더 우선인 것의 절댓값보다 크면
                    Integer tmp = A[i];
                    A[i] = A[child];
                    A[child] = tmp;
                    percolateDown(child);
                } else if (Math.abs(A[i]) == Math.abs(A[child])) { // 둘의 절댓값이 같으면
                    if (A[i].compareTo(A[child]) > 0) { // 현재 노드가 자식 중 더 작은 자식보다 클 때
                        Integer tmp = A[i];
                        A[i] = A[child];
                        A[child] = tmp;
                        percolateDown(child);
                    }
                }
            }
        }

        public Integer deleteMin(){
            if (!isEmpty()) {
                Integer min = A[0];
                A[0] = A[numItems - 1];
                numItems--;
                percolateDown(0);
                return min;
            }
            return null;
        }

        public Integer min(){
            if (!isEmpty()) {
                return A[0];
            }
            return null;
        }

        public void buildHeap() {
            if (numItems >= 2) {
                for (int i = (numItems - 2) / 2; i >= 0; i--) {
                    percolateDown(i);
                }
            }
        }

        public boolean isEmpty() {
            return numItems == 0;
        }

        public void clear() {
            A = new Integer[A.length];
            numItems = 0;
        }

        public void heapSort(){
            buildHeap();
            for (int i = numItems - 1; i >= 1; i--) {
                A[i] = deleteMin();
            }
        }
    }
}
