import javax.swing.JOptionPane;

public class Exemplo07_caixa {
    
    public static void main(String[] args) {
        
        // Exibir uma mensagem
        //JOptionPane.showMessageDialog(null, "Olá mundo!");
        //JOptionPane.showMessageDialog(null, "Olá novamente", "Título", JOptionPane.WARNING_MESSAGE);

        // Capturar dados
        //String nome = JOptionPane.showInputDialog(null, "Qual é o seu nome?");
        // try{
        //     int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual é sua idade?"));
        //     double altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe sua altura"));
        // }catch(Exception erro){
        //     JOptionPane.showMessageDialog(null, "Falha: " + erro.getMessage());
        // }

        int opcao = JOptionPane.showConfirmDialog(null, "Está gostando de Java?", "", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, opcao == 0 ? "Que bom" : "Que pena!");

    }

}
