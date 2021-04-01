public class Exemplo03_condicional {
    
    public static void main(String[] args) {
        
        // Variável idade
        int idade = 20;

        // Condicional
        if(idade >= 18){
            System.out.println("Maior de idade");
        }else{
            System.out.println("Menor de idade");
        }

        // Operador ternário
        System.out.println(idade >= 18 ? "Maior de idade" : "Menor de idade");

    }

}
