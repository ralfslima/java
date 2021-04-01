public class Pessoa {

    // Atributos
    public String nome;
    public int idade;
    public double peso, altura;

    // Métodos
    private String situacaoIdade(){
        return idade >= 18 ? "Maior de idade" : "Menor de idade";
    }

    private double calculoIMC(){
        return peso / (altura * altura);
    }

    private String situacaoIMC(){
        String situacao;

        if(calculoIMC() < 17){
            situacao = "Abaixo do peso";
        }else if(calculoIMC() < 25){
            situacao = "Peso normal";
        }else{
            situacao = "Acima do peso";
        }

        return situacao;
    }

    public void mensagem(){
        System.out.println(situacaoIdade());
        System.out.println(calculoIMC());
        System.out.println(situacaoIMC());
    }

}
