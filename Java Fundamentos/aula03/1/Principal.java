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
                case 4: JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema"); break;
            }
        }while(opcao != 4);

    }

}
