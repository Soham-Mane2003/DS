import java.util.Scanner;

public class Ring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int[] processes = new int[n];

        for(int i=0;i<n;i++) {
            processes[i] = i + 1;
        }

        System.out.print(
            "\nEnter process initiating election: "
        );

        int initiator = sc.nextInt();

        System.out.println("\nElection Message Passing:");

        int current = initiator;

        do {

            int next = (current % n) + 1;

            System.out.println(
                "Process " + current +
                " sends message to Process " +
                next
            );

            current = next;

        } while(current != initiator);

        System.out.println(
            "\nProcess " + n +
            " becomes Coordinator"
        );

        sc.close();
    }
}