import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Acao {
    
    // Vetor (ArrayList)
    static ArrayList dados = new ArrayList<Contato>();

    // Cadastrar
    public void cadastrar(){

        // Obter os dados
        Contato c = new Contato();
        c.setNome(JOptionPane.showInputDialog(null, "Informe o nome"));
        c.setEndereco(JOptionPane.showInputDialog(null, "Informe o endereço"));
        c.setEmail(JOptionPane.showInputDialog(null, "Informe o e-mail"));

        // Adicionar no vetor
        dados.add(c);

        // Mensagem
        JOptionPane.showMessageDialog(null, "Cadastro efetuado");

    }

    // Selecionar
    public void selecionar(){

        // Variável
        String texto = "Lista de contatos \n";

        // Laço
        for(int indice = 0; indice < dados.size(); indice++){
            Contato c = new Contato();
            c = (Contato) dados.get(indice);

            texto += "\nNome: " + c.getNome();
            texto += " | Endereço: " + c.getEndereco();
            texto += " | E-mail: " + c.getEmail();
        }

        // Exibir mensagem
        JOptionPane.showMessageDialog(null, texto);

    }

    // Verificar contato a ser excluído
    private int verificaExclusao(String nome){

        // Variável
        int posicao = -1;

        // Laço
        for(int i=0; i<dados.size(); i++){
            Contato c = new Contato();
            c = (Contato) dados.get(i);

            if(c.getNome().equals(nome)){
                posicao = i;
                break;
            }
        }

        // Retorno
        return posicao;

    }

    // Excluir
    public void excluir(){

        // Obter o nome
        String nome = JOptionPane.showInputDialog(null, "Informe um nome para remover");

        // Validar a exclusão
        int valida = verificaExclusao(nome);

        // Condicional
        if(valida == -1){
            JOptionPane.showMessageDialog(null, "Contato não encontrado");
        }else{
            dados.remove(valida);
            JOptionPane.showMessageDialog(null, "Contato removido com sucesso");
        }

    }

}
