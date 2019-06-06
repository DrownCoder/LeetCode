import java.util.Stack;

/**
 * Author : xuan.
 * Date : 2019-06-05.
 * Description :两个栈实现一个队列，两个队列实现一个栈
 * https://www.cnblogs.com/tracyhan/p/5490775.html
 */
class QA21 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Queue queue = new Queue();
        StackQ stackQ = new StackQ();

        for (int i : arr) {
            queue.push(i);
            stackQ.push(i);
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.pop());
        }

        while (!stackQ.isEmpty()) {
            System.out.print(stackQ.pop());
        }
    }

    public static class Queue<T> {
        private Stack<T> stack1, stack2;


        public Queue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(T value) {
            stack1.push(value);
        }

        public T pop() {
            if (stack2.size() > 0) {
                return stack2.pop();
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        public int size() {
            return stack1.size() > 0 ? stack1.size() : stack2.size();
        }
    }


    public static class StackQ<T> {
        public Queue<T> queue1, queue2;

        public StackQ() {
            queue1 = new Queue<>();
            queue2 = new Queue<>();
        }

        public void push(T value) {
            queue1.push(value);
        }

        public T pop() {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.push(queue1.pop());
            }
            T result = queue1.pop();
            while (!queue2.isEmpty()) {
                queue1.push(queue2.pop());
            }
            return result;
        }

        public int size() {
            return queue1.size() > 0 ? queue1.size() : queue2.size();
        }

        public boolean isEmpty() {
            return queue1.isEmpty();
        }
    }
}
