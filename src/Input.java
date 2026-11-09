import java.util.Scanner;

public class Input {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Broker broker = new Broker();

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n1. Add Message");
            System.out.println("2. Run Messages");
            System.out.println("3. View and Clear DLQ Messages");
            System.out.println("4. Exit");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("Message ID: ");
                String id = input.nextLine();

                System.out.print("Payload: ");
                String payload = input.nextLine();

                System.out.print("Success Chance: ");
                int successChance = input.nextInt();
                input.nextLine();

                broker.addMessage(
                        new Message(id, payload, successChance));

            } else if (choice == 2) {

                broker.processBatch();

            } else if (choice == 3) {

                broker.viewAndClearDLQMessages();

            }
        }

        input.close();
    }
}