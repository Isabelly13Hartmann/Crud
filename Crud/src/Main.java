import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 0

        );

        server.createContext("/", exchange -> {

            String html = """

                        <h1>Bem-vindo</h1>

                        <a href='/clientes'>Ver Clientes</a>

                    """;

            exchange.sendResponseHeaders(200, html.length());

            OutputStream os = exchange.getResponseBody();

            os.write(html.getBytes());

            os.close();

        });

        server.start();

        System.out.println("Servidor em http://localhost:8080");

    }

}