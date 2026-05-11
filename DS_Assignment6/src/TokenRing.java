import java.util.Scanner;

public class TokenRing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int token = 0;

        int choice;

        do {

            System.out.println(
                "\nProcess " + token +
                " has the TOKEN"
            );

            System.out.print(
                "Does Process " + token +
                " want to enter Critical Section? (1=yes / 0=no): "
            );

            choice = sc.nextInt();

            if(choice == 1) {

                System.out.println(
                    "\nProcess " + token +
                    " ENTERING Critical Section"
                );

                System.out.println(
                    "Process " + token +
                    " EXECUTING..."
                );

                System.out.println(
                    "Process " + token +
                    " EXITING Critical Section"
                );
            }

            token = (token + 1) % n;

            System.out.print(
                "\nContinue Simulation? (1=yes / 0=no): "
            );

            choice = sc.nextInt();

        } while(choice == 1);

        sc.close();
    }
}