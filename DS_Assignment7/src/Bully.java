import java.util.Scanner;

public class Bully {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int[] processes = new int[n];

        for(int i=0;i<n;i++) {
            processes[i] = i + 1;
        }

        int coordinator = n;

        System.out.println(
            "\nProcess " + coordinator +
            " is Coordinator"
        );

        System.out.print(
            "\nEnter process which initiates election: "
        );

        int initiator = sc.nextInt();

        System.out.println(
            "\nElection started by Process " +
            initiator
        );

        for(int i=initiator;i<n;i++) {

            System.out.println(
                "Election message sent from Process "
                + initiator +
                " to Process " +
                processes[i]
            );
        }

        coordinator = n;

        System.out.println(
            "\nProcess " + coordinator +
            " becomes new Coordinator"
        );

        sc.close();
    }
}