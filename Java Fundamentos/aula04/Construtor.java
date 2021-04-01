import javax.swing.JOptionPane;

public class Construtor {

    // Primeiro Construtor
    public Construtor(){
        JOptionPane.showMessageDialog(null, "Executando o 1º construtor");
    }

    // Segundo Construtor
    public Construtor(String nome){
        JOptionPane.showMessageDialog(null, "Olá " + nome);
    }

    // Terceiro Construtor
    public Construtor(String nome, int idade){
        JOptionPane.showMessageDialog(null, "Olá " + nome + " você tem " + idade + " anos.");
    }
    
}