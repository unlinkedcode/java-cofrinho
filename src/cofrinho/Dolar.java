package cofrinho;

public class Dolar extends Moeda {
    public Dolar(double valor) {
        super(valor); // Chama o construtor da superclasse com o valor da moeda atual.

        this.simbolo = "US$"; // Define o símbolo da moeda.
    }

    /** Converte o valor da moeda atual para Real. */
    public Real conveter() {
        double taxaCambio = 6.08;

        return new Real(this.valor * taxaCambio);
    }
}
