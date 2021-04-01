public class Exemplo05_vetor {
    
    public static void main(String[] args) {
        
        // 1º Exemplo
        //String[] cores = {"Azul", "Verde", "Amarelo"};

        // 2º Exemplo
        String[] cores = new String[3];
        cores[0] = "Verde";
        cores[1] = "Roxo";
        cores[2] = "Vermelho";
        
        for(int indice=0; indice<cores.length; indice++){
            System.out.println(cores[indice]);
        }

    }

}
