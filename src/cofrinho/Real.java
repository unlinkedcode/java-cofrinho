package cofrinho;

public class Real extends Moeda {
    public Real(double valor) {
        super(valor); // Chama o construtor da superclasse com o valor da moeda atual.

        this.simbolo = "R$"; // Define o símbolo da moeda.
    }

    /** Retorna a instância atual, pois ela já representa o valor em Real. */
    public Real conveter() {
        return this;
    }
}
