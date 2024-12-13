package cofrinho;

// Esta é a classe principal que contém o método main.
public class Principal {
    public static void main(String[] args) throws Exception {
        Cofrinho cofrinho = new Cofrinho(); // Instancia um novo cofrinho.
        Prompt prompt = new Prompt(cofrinho); // Instancia um novo prompt.

        prompt.greet();
        prompt.iniciar();
    }
}
