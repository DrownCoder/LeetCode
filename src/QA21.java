import java.util.Stack;

/**
 * Author : xuan.
 * Date : 2019-06-05.
 * Description :两个栈实现一个队列，两个队列实现一个栈
 */
class QA21 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Queue queue = new Queue();
        for (int i : arr) {
            queue.push(i);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.pop());
        }
    }

    public static class Queue {
        private Stack<Integer> stack1, stack2;


        public Queue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int value) {
            stack1.push(value);
        }

        public int pop() {
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
    }
}
