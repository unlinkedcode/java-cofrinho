package cofrinho;

import java.lang.Iterable;
import java.util.List;
import java.util.ArrayList;

public class Cofrinho {
    // Define um conjunto de moedas no cofrinho.
    private List<Moeda> listaMoedas;

    /** Constrói um cofrinho com um conjunto de moedas o. */
    public Cofrinho() {
        this.listaMoedas = new ArrayList<>();
    }

    /** Adiciona uma moeda ao cofrinho. */
    public boolean adicionar(Moeda moeda) {
        return this.listaMoedas.add(moeda);
    }

    /** Remove uma moeda do cofrinho. */
    public boolean remover(Moeda moeda) {
        return this.listaMoedas.remove(moeda);
    }

    /** Retorna um iterable com as moedas presentes no cofrinho. */
    public Iterable<Moeda> listagemMoedas() {
        return this.listaMoedas;
    }

    /** Calcula o valor das moedas presentes no cofrinho (convertido para Real). */
    public Real totalConvertido() {
        Real total = new Real(0);

        this.listaMoedas.forEach(moeda -> total.somar(moeda.conveter().valor));

        return total;
    }

    public int length() {
        return this.listaMoedas.size();
    }
}
