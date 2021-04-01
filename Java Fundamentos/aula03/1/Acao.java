import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Acao {
    
    // Vetor (ArrayList)
    static ArrayList<Produto> dados = new ArrayList<Produto>();

    // Cadastrar
    public void cadastrar(){

        // Laço para obter o nome do produto
        String nome;
        boolean validaLaco = false;
        do{
            // Obter o nome do produto
            nome = JOptionPane.showInputDialog(null, "Informe o nome do produto");

            // Validar a exclusão
            int valida = verificaExistencia(nome);

            System.out.println(valida);

            // Condicional
            if(valida == -1){
                validaLaco = true;
            }else{
                JOptionPane.showMessageDialog(null, "Produto já cadastrado, tente novamente");
            }
        }while(validaLaco == false);

        // Obter os dados
        Produto p = new Produto();
        p.setProduto(nome);
        p.setMarca(JOptionPane.showInputDialog(null, "Informe a marca"));
        p.setValor(Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor")));

        // Adicionar no vetor
        dados.add(p);

        // Mensagem
        JOptionPane.showMessageDialog(null, "Cadastro efetuado");

    }

    // Selecionar
    public void selecionar(){

        // Variável
        String texto = "Lista de produtos \n";

        // Laço
        for(int indice = 0; indice < dados.size(); indice++){
            Produto p = new Produto();
            p = (Produto) dados.get(indice);

            texto += "\nProduto: " + p.getProduto();
            texto += " | Marca: " + p.getMarca();
            texto += " | Valor: " + p.getValor();
        }

        // Exibir mensagem
        JOptionPane.showMessageDialog(null, texto);

    }

    // Verificar produto a ser cadastrado ou excluído
    private int verificaExistencia(String nome){

        // Variável
        int posicao = -1;

        // Laço
        for(int i=0; i<dados.size(); i++){
            Produto p = new Produto();
            p = (Produto) dados.get(i);

            if(p.getProduto().toLowerCase().equals(nome.toLowerCase())){
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
        int valida = verificaExistencia(nome);

        // Condicional
        if(valida == -1){
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }else{
            dados.remove(valida);
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
        }

    }

}
