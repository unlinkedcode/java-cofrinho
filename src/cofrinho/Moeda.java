package cofrinho;

public abstract class Moeda {
    public String simbolo; // Representará o símbolo da moeda.
    public double valor; // Representá o valor da moeda na sua unidade original.

    public Moeda(double valor) {
        this.valor = valor; // Atribui o valor da moeda.
    }

    /** Método abstrato para converter o valor da moeda para Real. */
    public abstract Real conveter();

    /** Retorna uma string com o símbolo e o valor da moeda. */
    final public String info() {
        return this.simbolo + String.format("%.2f", this.valor);
    }

    /** Soma um valor ao valor da moeda atual. */
    final protected void somar(double valor) {
        this.valor += valor;
    }
}