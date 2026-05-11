import java.rmi.registry.*;

public class Server {

    public static void main(String[] args) {

        try {

            CalculatorImpl obj = new CalculatorImpl();

            Registry registry = LocateRegistry.createRegistry(1098);

            registry.rebind("Calculator", obj);

            System.out.println("Server ready...");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}