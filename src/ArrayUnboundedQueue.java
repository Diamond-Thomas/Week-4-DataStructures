public class ArrayUnboundedQueue<T> implements QueueInterface<T> {
    private T[] innerArray;
    private int front;
    private int back;
    private int count;

    private void expandCapacity() {
        T[] largerArray = (T[]) new Object[innerArray.length * 2];

        for(int i = 0; i < count; i++) {
            largerArray[i] = innerArray[(front + i) % innerArray.length];
        }

        innerArray = largerArray;
        front = 0;
        back = count;
    }

    public ArrayUnboundedQueue() {
        innerArray = (T[]) new Object[10];
        back = 0;
        front = 0;
    }



    @Override
    public void enqueue(T element) throws QueueOverflowException{
        if(isFull()){
            expandCapacity();
        } else{
            innerArray[back] = element;
            back++;
            if(back >= innerArray.length) {
                back = 0;
            }
            count++;
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException{
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else{
            T result = innerArray[front];
            innerArray[front] = null;
            front++;
            if(front >= innerArray.length) {
                front = 0;
            }
            count--;
            return result;
        }
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return count;
    }
}


