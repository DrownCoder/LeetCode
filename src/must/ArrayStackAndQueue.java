package must;

/**
 * Author : xuan.
 * Date : 2019-03-28.
 * Description :the description of this file
 */
class ArrayStackAndQueue {
    public static void main(String[] args) {

    }

    /**
     * 数组实现栈
     */
    public static class ArrayStack {
        private long[] a;
        private int size;
        private int top = -1;

        public ArrayStack(int maxSize) {
            this.size = maxSize;
            this.a = new long[maxSize];
            this.top = -1;
        }

        public void push(long value) {
            if (isFull()) {
                return;
            }
            a[++top] = value;
        }

        public long pop() {
            if (isEmpty()) {
                System.out.println("the stack is null");
                return 0;
            }
            return a[top--];
        }

        public boolean isFull() {
            return top == size - 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static class ArrayStack2 {
        private long[] a;
        private int size;
        private int top;

        public ArrayStack2(int size) {
            this.size = size;
            a = new long[size];
            top = -1;
        }

        public void push(long value) {
            if (isFull()) {
                return;
            }
            a[++top] = value;
        }

        public long pop() {
            if (isEmpty()) {
                return -1;
            }
            return a[top--];
        }


        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == size - 1;
        }

    }

    /**
     * 数组实现队列
     */
    public static class ArrayQueue {
        private long[] a;
        private int size;
        private int fillSize;
        private int front, end;

        public ArrayQueue(int size) {
            this.size = size;
            a = new long[size];
            front = 0;
            end = -1;
            fillSize = 0;
        }

        public void put(long value) {
            if (isFill()) {
                return;
            }
            end = ++end % size;
            a[end] = value;
            fillSize++;
        }

        public long remove() {
            if (isEmpty()) {
                return 0;
            }
            fillSize--;
            return a[front++];
        }

        public long peek() {
            if (isEmpty()) {
                return 0;
            }
            return a[front];
        }

        public boolean isFill() {
            return fillSize == size;
        }

        public boolean isEmpty() {
            return fillSize == 0;
        }
    }

    public static class ArrayQueue2 {
        private long[] a;
        private int fillSize;
        private int size;
        private int front, end;

        public ArrayQueue2(int size) {
            this.size = size;
            a = new long[size];
            front = 0;
            end = -1;
        }

        public void put(int value) {
            if (isFill()) {
                return;
            }
            end = ++end % size;
            a[end] = value;
        }

        public long remove() {
            if (isEmpty()) {
                return 0;
            }
            fillSize--;
            return a[front++];
        }

        public long peek() {
            if (isEmpty()) {
                return 0;
            }
            return a[front];
        }

        public boolean isFill() {
            return fillSize == size;
        }

        public boolean isEmpty() {
            return fillSize != 0;
        }
    }

    /**
     * 数组实现优先级队列，从大到小排列
     */
    public static class PriorityQueue {
        private long[] a;
        private int size;
        private int fillSize;

        private PriorityQueue(int size) {
            this.size = size;
            a = new long[size];
            fillSize = 0;
        }

        public void insert(long value) {
            if (isFill()) {
                return;
            }
            if (isEmpty()) {
                a[fillSize++] = value;
            } else {
                int j;
                for (j = fillSize - 1; j >= 0; j--) {
                    if (value > a[j]) {
                        a[j + 1] = a[j];
                    } else {
                        break;
                    }
                }
                a[j] = value;
                fillSize++;
            }

        }

        public long remove() {
            if (isEmpty()) {
                return 0;
            }
            return a[--fillSize];
        }

        public boolean isFill() {
            return fillSize == size;
        }

        public boolean isEmpty() {
            return fillSize == 0;
        }
    }

    public static class PriorityQueue2 {
        private long a[];
        private int size;
        private int fillSize;

        public PriorityQueue2(int size) {
            this.size = size;
            this.a = new long[size + 1];
            fillSize = 0;
        }

        public void insert(long value) {
            if (isFill()) {
                return;
            }
            if (isEmpty()) {
                a[fillSize++] = value;
            } else {
                int j = fillSize - 1;
                for (; j >= 0; j--) {
                    if (value > a[j]) {
                        a[j + 1] = a[j];
                    } else {
                        break;
                    }
                }
                a[j] = value;
                fillSize++;
            }
        }

        public long remove() {
            if (isEmpty()) {
                return -1;
            }
            return a[--fillSize];
        }

        public boolean isEmpty() {
            return fillSize == 0;
        }

        public boolean isFill() {
            return fillSize == size;
        }
    }
}
