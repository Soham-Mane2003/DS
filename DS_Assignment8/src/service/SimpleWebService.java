import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SimpleWebService {

    public static void main(String[] args) throws IOException {
        // Create server on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/add", (exchange) -> {
            String response;
            int statusCode = 200;

            try {
                String query = exchange.getRequestURI().getQuery();
                
                // Safety check for missing query string
                if (query == null || !query.contains("=")) {
                    throw new IllegalArgumentException("Missing parameters. Use ?a=5&b=10");
                }

                String[] params = query.split("&");
                int a = 0, b = 0;

                // Parsing logic with simple validation
                for (String param : params) {
                    String[] pair = param.split("=");
                    if (pair.length > 1) {
                        if (pair[0].equals("a")) a = Integer.parseInt(pair[1]);
                        if (pair[0].equals("b")) b = Integer.parseInt(pair[1]);
                    }
                }

                int result = a + b;
                response = "Result = " + result;

            } catch (Exception e) {
                // Catching parsing errors or null pointers
                statusCode = 400;
                response = "Error: " + e.getMessage();
            }

            // Convert string to bytes once to ensure correct length
            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
            
            exchange.sendResponseHeaders(statusCode, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        });

        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server running at http://localhost:8000/add?a=5&b=10");
    }
}