package cofrinho;

public class Euro extends Moeda {
    public Euro(double valor) {
        super(valor); // Chama o construtor da superclasse com o valor da moeda atual.

        this.simbolo = "€"; // Define o símbolo da moeda.
    }

    /** Converte o valor da moeda atual para Real. */
    public Real conveter() {
        double taxaCambio = 6.42;

        return new Real(this.valor * taxaCambio);
    }
}
