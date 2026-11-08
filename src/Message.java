public class Message {
    String messageId;
    String payload;
    int retryCount = 0;

    public Message(String messageId, String payload) {
        this.messageId = messageId;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Message ID: " + messageId +
                ", Payload: " + payload +
                ", Retry Count: " + retryCount;
    }









    public static void main(String[] args) {

        ArrayUnboundedQueue<Message> queue = new ArrayUnboundedQueue<>();

        queue.enqueue(new Message("1", "First"));
        queue.enqueue(new Message("2", "Second"));
        queue.enqueue(new Message("3", "Third"));


        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }


}






