public class Message {
    String messageId;
    String payload;
    int retryCount = 0;
    int successChance;

    public Message(String messageId, String payload, int successChance) {
        this.messageId = messageId;
        this.payload = payload;
        this.successChance = successChance;
    }

    @Override
    public String toString() {
        return "Message ID: " + messageId + ", Payload: " + payload + ", Retry Count: " + retryCount + ", Success Chance: " + successChance;
    }




    // TESTER

    public static void main(String[] args) {

        Broker broker = new Broker();

        broker.addMessage(new Message("1", "First", 90));
        broker.addMessage(new Message("2", "Second", 50));
        broker.addMessage(new Message("3", "Third", 10));

        broker.processBatch();

    }


}






