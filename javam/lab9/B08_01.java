public class RecursiveStack<T> {
    private T value;
    private RecursiveStack<T> next;

    public RecursiveStack() {
        this.value = null;
        this.next = null;
    }

    public void push(T value) {
        RecursiveStack<T> newStack = new RecursiveStack<>();
        newStack.value = this.value;
        newStack.next = this.next;
        this.value = value;
        this.next = newStack;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T result = this.value;
        this.value = this.next.value;
        this.next = this.next.next;
        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.value;
    }

    public boolean isEmpty() {
        return this.value == null && this.next == null;
    }

    public static void main(String[] args) {
        RecursiveStack<Integer> stack = new RecursiveStack<>();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
