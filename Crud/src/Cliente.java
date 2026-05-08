public class Cliente {
    // Atributos da classe Cliente
    public int id;
    public String nome;
    public String email;
    public String telefone;

    // public String telefone;
    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // to String para mostrar o nome do cliente
    @Override
    public String toString() {
        return nome;

    }
}
