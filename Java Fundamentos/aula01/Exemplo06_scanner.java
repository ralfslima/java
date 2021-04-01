import java.util.Scanner;

public class Exemplo06_scanner {

    public static void main(String[] args) {
        
        // Criar um objeto
        Scanner obterDados = new Scanner(System.in);

        // Perguntar
        System.out.println("Informe seu nome");

        // Obter o nome
        String nome = obterDados.next();

        // Excluir o objeto
        obterDados.close();

        // Concatenar uma frase com o nome
        System.out.println("O nome informado é " + nome);

    }

}

