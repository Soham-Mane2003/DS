package service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class CalculatorService {

    @WebMethod
    public int add(int a, int b) {

        return a + b;
    }

    public static void main(String[] args) {

        Endpoint.publish(
            "http://localhost:8080/calculator",
            new CalculatorService()
        );

        System.out.println(
            "Web Service Started..."
        );
    }
}