public interface QueueInterface<T> {
    void enqueue(T element) throws QueueOverflowException;
    T dequeue() throws QueueUnderflowException;
    boolean isEmpty();
    boolean isFull();
    int size();

    class QueueOverflowException extends RuntimeException {
    }

    class QueueUnderflowException extends RuntimeException {
    }
}