import java.sql.Connection;
import java.sql.DriverManager;

public class LigacaoBD {
    // Configurações de conexão com a base de dados
    private static final String URL = "jdbc:mysql://localhost:3306/appdb";
    // O nome de utilizador e a senha devem ser configurados de acordo com a sua
    // base de dados
    private static final String USER = "appuser";
    // A senha deve ser configurada de acordo com a sua base de dados
    private static final String PASSWORD = "apppass";

    // Método para estabelecer a ligação à base de dados
    public static Connection ligar() {
        // Tentar estabelecer a ligação à base de dados usando as configurações fornecidas
        try {
            // Criar a ligação usando DriverManager e retornar a conexão
            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD);
            return con;
        } catch (Exception e) {
            System.out.println("Erro ao ligar à base de dados!");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("A testar ligação à base de dados...");
        // Chamar o método ligar para estabelecer a ligação à base de dados
        Connection con = ligar();

        if (con != null) {
            System.out.println("Ligação realizada com sucesso!");
            try {
                con.close();
                System.out.println("Ligação fechada.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Falha na ligação!");
        }
    }
}
