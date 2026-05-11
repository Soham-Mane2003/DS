import mpi.*;

public class Berkeley {

    public static void main(String[] args) throws Exception {

        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        // Each process has different clock time
        int localClock = 10 + (rank * 5);

        System.out.println(
                "Process " + rank +
                " initial clock = " +
                localClock
        );

        int[] allClocks = new int[size];

        // Gather all clock values at all processes
        MPI.COMM_WORLD.Allgather(
                new int[]{localClock},
                0,
                1,
                MPI.INT,
                allClocks,
                0,
                1,
                MPI.INT
        );

        int average = 0;

        // Master process calculates average
        if(rank == 0) {

            int sum = 0;

            for(int i=0;i<size;i++) {
                sum += allClocks[i];
            }

            average = sum / size;

            System.out.println(
                    "\nAverage Clock Time = " +
                    average +
                    "\n"
            );
        }

        int[] avg = new int[1];

        // Send average to all processes
        if(rank == 0) {
            avg[0] = average;
        }

        MPI.COMM_WORLD.Bcast(
                avg,
                0,
                1,
                MPI.INT,
                0
        );

        int adjustment = avg[0] - localClock;

        int synchronizedClock =
                localClock + adjustment;

        System.out.println(
                "Process " + rank +
                " adjusted by " +
                adjustment +
                " → New Clock = " +
                synchronizedClock
        );

        MPI.Finalize();
    }
}
