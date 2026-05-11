import java.rmi.registry.*;

public class Client {

    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1098);

            Calculator obj = (Calculator) registry.lookup("Calculator");

            int result = obj.add(10, 5);

            System.out.println("Result = " + result);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}