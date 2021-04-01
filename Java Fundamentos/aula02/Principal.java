import javax.swing.JOptionPane;

public class Principal {
    
    public static void main(String[] args) {

        // Texto
        String texto = "1) Cadastrar\n";
               texto +="2) Selecionar\n";
               texto +="3) Excluir\n";
               texto +="4) Finalizar";

        // Objeto da classe Acao
        Acao a = new Acao();

        // Laço de repetição
        int opcao = 0;
        do{

            // Obter a opção
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, texto));

            // Escolha
            switch(opcao){
                case 1: a.cadastrar(); break;
                case 2: a.selecionar(); break;
                case 3: a.excluir(); break;
                case 4: JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema, vc é legal :)"); break;
            }
        }while(opcao != 4);




        // Aluno a = new Aluno();
        // a.setNome("Ralf");
        // System.out.println(a.getNome());

        // Calculos c = new Calculos();
        // c.multiplicar(5, 6);

        // Pessoa p = new Pessoa();
        // p.nome = "Rebeca";
        // p.altura = 1.74;
        // p.peso = 62;
        // p.idade = 23;
        // p.mensagem();
        
        // Instanciar objeto
        // Carro objeto = new Carro();
        // objeto.fabricante = "Hyundai";
        // objeto.modelo = "HB20";
        // objeto.ano = 2020;
        // objeto.tetoSolar = false;
        // objeto.valor = 55000; 
        // objeto.mensagem();

    }

}
