package cofrinho;

import java.util.Scanner;

public class Prompt {
    private Cofrinho cofrinho;

    public Prompt(Cofrinho cofrinho) {
        this.cofrinho = cofrinho;
    }

    /** Inicia o prompt de menu do cofrinho. */
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.print("> ");
                String linha = scanner.nextLine().trim();

                String[] linhaPartes = linha.split(" ", 2); // Separa a linha em <comando> e <argumento>, se houver um.

                String comando = linhaPartes[0].toLowerCase(); // Converte o comando para letras minúsculas.
                String argumento = linhaPartes.length > 1 ? linhaPartes[1] : ""; // Define o argumento, se houver.

                // Chama o método 'chamar' com o comando e argumento.
                chamar(comando, argumento);
            }
        } finally {
            scanner.close(); // Fecha o scanner após o uso.
        }
    }

    /** Chama o comando do menu do cofrinho com o argumento fornecido. */
    protected void chamar(String comando, String argumento) {
        switch (comando.toLowerCase()) {
            case "add":
                add(argumento);
                break;
            case "rm":
                rm(argumento);
                break;
            case "list":
                list(argumento);
                break;
            case "calc":
                calc(argumento);
                break;
            case "help":
                help(argumento);
                break;
            case "exit":
                exit(argumento);
                break;
            default:
                error("Comando não encontrado.");
                return;
        }
    }

    /** Exibe a mensagem inicial do menu do cofrinho. */
    protected void greet() {
        System.out.println("Bem-vindo! Este é o menu do cofrinho.");
        System.out.println("Digite 'help' caso tenha dúvidas.");
    }

    /** Exibe o modo de uso dos comandos. */
    protected void help(String argumento) {
        System.out.println("add <dolar/real/euro> <valor>: Adiciona uma moeda.");
        System.out.println("rm <índice>: Remove uma moeda.");
        System.out.println("list: Lista todas as moedas.");
        System.out.println("calc: Calcula o valor convertido das moedas.");
        System.out.println("help: Exibe o modo de uso dos comandos.");
        System.out.println("exit: Sai do programa.");
    }

    /**
     * Adiciona uma moeda ao cofrinho. O argumento deve conter o nome da moeda e
     * seu valor, separados por um espaço.
     */
    protected void add(String argumento) {
        String[] argumentos = argumento.split(" ");
        if (argumentos.length == 0) {
            error("São necessários os argumentos: <moeda> <valor>.");
            return;
        } else if (argumentos.length == 1) {
            error("É necessário o argumento: <valor>.");
            return;
        } else if (argumentos.length > 2) {
            error("Argumentos inválidos.");
            return;
        }

        String moedaNome = argumentos[0].toLowerCase();

        try {
            double valor = Double.parseDouble(argumentos[1]);

            if (valor <= 0) {
                error("Quantidade inválida.");
                return;
            }

            Moeda moeda = null;

            switch (moedaNome) {
                case "dolar":
                    moeda = new Dolar(valor);
                    break;
                case "real":
                    moeda = new Real(valor);
                    break;
                case "euro":
                    moeda = new Euro(valor);
                    break;
                default:
                    error("Esta moeda não é suportada.");
                    return;
            }

            this.cofrinho.adicionar(moeda);

            System.out.println("Moeda adicionada no índice " + (this.cofrinho.length() - 1) + ": " + moeda.info());
        } catch (NumberFormatException e) {
            error("O argumento não é um número válido.");
            return;
        }
    }

    /** Remove uma moeda do cofrinho a partir de um índice fornecido. */
    protected void rm(String argumento) {
        try {
            // Converte a string para um inteiro.
            int indice = Integer.parseInt(argumento);

            // Verifica se o índice está dentro do intervalo válido.
            if (indice < 0 || indice >= this.cofrinho.length()) {
                error("Índice inválido. O índice deve ser entre 0 e " + (this.cofrinho.length() - 1) + ".");
                return;
            }

            // Itera sobre as moedas e encontra a moeda pelo índice
            int i = 0;

            for (Moeda moeda : this.cofrinho.listagemMoedas()) {
                if (i == indice) {
                    this.cofrinho.remover(moeda);

                    System.out.println("Moeda removida: " + moeda.info());

                    return;
                }

                i++;
            }
        } catch (NumberFormatException e) { // Caso o argumento não seja um número válido
            error("O argumento fornecido não é um número válido.");
        }
    }

    /** Lista todas as moedas armazenadas no cofrinho. */
    protected void list(String argumento) {
        int i = 0;

        for (Moeda moeda : this.cofrinho.listagemMoedas()) {
            System.out.println(i + " - " + moeda.info());

            i++;
        }
    }

    /** Calcula e exibe o valor total convertido das moedas no cofrinho. */
    protected void calc(String argumento) {
        System.out.println(this.cofrinho.totalConvertido().info());
    }

    /** Encerra o programa. */
    protected void exit(String argumento) {
        System.out.println("Tchau!");
        System.exit(0);
    }

    /** Exibe uma mensagem de erro. */
    protected static void error(String msg) {
        System.err.println("Erro: " + msg);
    }
}
