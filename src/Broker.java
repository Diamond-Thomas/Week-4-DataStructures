import java.util.Random;

public class Broker{
    private QueueInterface<Message> Q;

    void processBatch(){
        Random random = new Random();

        int batchSize = Q.size();
        for(int i = 0; i < batchSize; i++) {
            Message current = Q.dequeue();

            int roll = random.nextInt(100);
            if (roll < current.successChance) {

                System.out.println("SUCCESS: " + current);

            } else {

                current.retryCount++;

                Q.enqueue(current);

                System.out.println("FAILED: " + current);
            }
        }
    }

    public void addMessage(Message message) {
        Q.enqueue(message);
    }

    public Broker() {
        Q = new ArrayUnboundedQueue<>();
    }

}
