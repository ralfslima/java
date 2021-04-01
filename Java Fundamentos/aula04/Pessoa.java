public class Pessoa extends Colaborador{

    // Atributos
    private String nome, email;
    private int idade;

    // Construtor
    public Pessoa(String nome, String email, int idade, String cargo, double salario){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.cargo = cargo;
        this.salario = salario;

        exibirPessoa();
        exibirColaborador();
    }

    // Exibir dados
    private void exibirPessoa(){
        System.out.println("Nome " + nome);
        System.out.println("E-mail " + email);
        System.out.println("Idade " + idade);
    }
    
}
