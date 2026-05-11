import java.util.Scanner;

public class ElectionAlgorithms {

    public static void bullyAlgorithm(
            int n,
            int initiator
    ) {

        System.out.println(
                "\n--- Bully Algorithm ---"
        );

        System.out.println(
                "\nElection started by Process "
                + initiator
        );

        for(int i = initiator + 1;
            i <= n;
            i++) {

            System.out.println(
                    "Election message sent from Process "
                    + initiator +
                    " to Process " + i
            );
        }

        System.out.println(
                "\nProcess " + n +
                " becomes new Coordinator"
        );
    }

    public static void ringAlgorithm(
            int n,
            int initiator
    ) {

        System.out.println(
                "\n--- Ring Algorithm ---"
        );

        int current = initiator;

        System.out.println(
                "\nElection Message Passing:"
        );

        do {

            int next = (current % n) + 1;

            System.out.println(
                    "Process " + current +
                    " sends message to Process "
                    + next
            );

            current = next;

        } while(current != initiator);

        System.out.println(
                "\nProcess " + n +
                " becomes new Coordinator"
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        int initiator;
        int choice;

        System.out.print(
                "Enter number of processes: "
        );

        n = sc.nextInt();

        do {

            System.out.println(
                    "\n===== Leader Election Menu ====="
            );

            System.out.println(
                    "1. Bully Algorithm"
            );

            System.out.println(
                    "2. Ring Algorithm"
            );

            System.out.println(
                    "3. Exit"
            );

            System.out.print(
                    "\nEnter your choice: "
            );

            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print(
                            "\nEnter initiator process: "
                    );

                    initiator = sc.nextInt();

                    bullyAlgorithm(
                            n,
                            initiator
                    );

                    break;

                case 2:

                    System.out.print(
                            "\nEnter initiator process: "
                    );

                    initiator = sc.nextInt();

                    ringAlgorithm(
                            n,
                            initiator
                    );

                    break;

                case 3:

                    System.out.println(
                            "\nProgram Exited."
                    );

                    break;

                default:

                    System.out.println(
                            "\nInvalid Choice"
                    );
            }

        } while(choice != 3);

        sc.close();
    }
}