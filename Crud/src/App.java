// Importar as classes necessárias para criar um servidor HTTP e lidar com conexões de rede
import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {
        // Criar um servidor HTTP na porta 8080
        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 0);
        // Definir o contexto para a raiz ("/") e a resposta a ser enviada quando essa rota for acessada
        server.createContext("/", exchange -> {
            // Criar uma resposta HTML simples
            String html = """
                        // Página inicial
                        <h1>Bem-vindo</h1>
                        // Link para a página de clientes
                        <a href='/clientes'>Ver Clientes</a>
                    """;
            // Enviar a resposta HTTP com o código de status 200 (OK) e o conteúdo HTML
            exchange.sendResponseHeaders(200, html.length());
            // Escrever a resposta no corpo da resposta HTTP
            OutputStream os = exchange.getResponseBody();
            // Converter a string HTML para bytes e escrever no OutputStream
            os.write(html.getBytes());
            // Fechar o OutputStream para indicar que a resposta foi enviada
            os.close();
        });
        // Iniciar o servidor para começar a aceitar conexões
        server.start();
        // Imprimir uma mensagem no console indicando que o servidor está rodando e em qual endereço ele pode ser acessado
        System.out.println("Servidor em http://localhost:8080");
    }
}