import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Acao {
    
    // Vetor (ArrayList)
    static ArrayList<Serie> dados = new ArrayList<Serie>();

    // Cadastrar
    public void cadastrar(){

        // Laço para obter o nome da série
        String nome;
        boolean validaLaco = false;
        do{
            // Obter o nome da série
            nome = JOptionPane.showInputDialog(null, "Informe o nome da série");

            // Validar a exclusão
            int valida = verificaExistencia(nome);

            System.out.println(valida);

            // Condicional
            if(valida == -1){
                validaLaco = true;
            }else{
                JOptionPane.showMessageDialog(null, "Série já cadastrada, tente novamente");
            }
        }while(validaLaco == false);

        // Obter os dados
        Serie s = new Serie();
        s.setNome(nome);
        s.setGenero(JOptionPane.showInputDialog(null, "Informe o gênero do filme"));
        s.setTemporada(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a temporada")));
        s.setClassificacao(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a classificação (entre 1 e 5)")));

        // Adicionar no vetor
        dados.add(s);

        // Mensagem
        JOptionPane.showMessageDialog(null, "Cadastro efetuado");

    }

    // Selecionar
    public void selecionar(){

        // Variável
        String texto = "Lista de séries \n";

        // Laço
        for(int indice = 0; indice < dados.size(); indice++){
            Serie s = new Serie();
            s = (Serie) dados.get(indice);

            texto += "\nNome: " + s.getNome();
            texto += " | Gênero: " + s.getGenero();
            texto += " | Temporada: " + s.getTemporada();
            texto += " | Classificação: " + s.getClassificacao();
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
            Serie s = new Serie();
            s = (Serie) dados.get(i);

            if(s.getNome().toLowerCase().equals(nome.toLowerCase())){
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
            JOptionPane.showMessageDialog(null, "Série não encontrada");
        }else{
            dados.remove(valida);
            JOptionPane.showMessageDialog(null, "Série removida com sucesso");
        }

    }


   // Cadastrar
   public void alterar(){

    // Laço para obter o nome da série
    String nome;
    boolean validaLaco = false;
    int valida = -1;
    do{
        // Obter o nome da série
        nome = JOptionPane.showInputDialog(null, "Informe o nome da série");

        // Validar a alteração
        valida = verificaExistencia(nome);

        // Condicional
        if(valida == -1){
            validaLaco = true;
        }else{
            JOptionPane.showMessageDialog(null, "Série já cadastrada, tente novamente");
        }

        }while(validaLaco == false);

        // Obter os dados
        Serie s = new Serie();
        s.setNome(nome);
        s.setGenero(JOptionPane.showInputDialog(null, "Informe o gênero do filme"));
        s.setTemporada(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a temporada")));
        s.setClassificacao(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a classificação (entre 1 e 5)")));

        // Alterar série no vetor
        dados.add(valida, s);

        // Mensagem
        JOptionPane.showMessageDialog(null, "Atualização realizada");

    }

}
