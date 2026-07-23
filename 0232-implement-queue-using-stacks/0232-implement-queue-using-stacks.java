class MyQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    public void push(int x) {
        first.push(x);
    }
    public int pop() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int firstElement = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return firstElement;
    }
    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int firstElement = second.peek();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return firstElement;
    }
    public boolean empty() {
        return first.isEmpty();
    }
}