import java.util.Random;

public class Broker {
    private QueueInterface<Message> Q;
    private QueueInterface<Message> deadLetterQueue;
    private final int MAX_RETRIES = 3;

    void processBatch() {
        Random random = new Random();

        while (!Q.isEmpty()) {

            Message current = Q.dequeue();

            int roll = random.nextInt(100);
            if (roll < current.successChance) {

                System.out.println("SUCCESS: " + current);

            } else {

                current.retryCount++;

                if (current.retryCount >= MAX_RETRIES) {

                    deadLetterQueue.enqueue(current);

                    System.out.println("MOVED TO DLQ: " + current);

                } else {

                    Q.enqueue(current);

                    System.out.println("FAILED: " + current);

                }
            }
        }
    }

    public void addMessage (Message message){
            Q.enqueue(message);
    }


    public Broker() {
            Q = new ArrayUnboundedQueue<>();
            deadLetterQueue = new ArrayUnboundedQueue<>();
    }

    public void viewAndClearDLQMessages() {
        while (!deadLetterQueue.isEmpty()) {
            System.out.println(deadLetterQueue.dequeue());
        }
    }


}
