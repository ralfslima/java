import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Acao {
    
    // Vetor (ArrayList)
    static ArrayList<Aluno> dados = new ArrayList<Aluno>();

    // Cadastrar
    public void cadastrar(){

        // Laço para obter o nome do aluno
        String nome;
        boolean validaLaco = false;
        do{
            // Obter o nome do produto
            nome = JOptionPane.showInputDialog(null, "Informe o nome do aluno");

            // Validar a exclusão
            int valida = verificaExistencia(nome);

            System.out.println(valida);

            // Condicional
            if(valida == -1){
                validaLaco = true;
            }else{
                JOptionPane.showMessageDialog(null, "Aluno já cadastrado, tente novamente");
            }
        }while(validaLaco == false);

        // Obter os dados
        Aluno a = new Aluno();
        a.setNome(nome);
        a.setNota1(Double.parseDouble(JOptionPane.showInputDialog(null, "Informe a primeira nota")));
        a.setNota2(Double.parseDouble(JOptionPane.showInputDialog(null, "Informe a segunda nota")));

        // Realizar a média
        a.setMedia((a.getNota1() + a.getNota2()) / 2);

        // Adicionar no vetor
        dados.add(a);

        // Mensagem
        JOptionPane.showMessageDialog(null, "Cadastro efetuado");

    }

    // Selecionar
    public void selecionar(){

        // Variável
        String texto = "Lista de alunos \n";

        // Laço
        for(int indice = 0; indice < dados.size(); indice++){
            Aluno a = new Aluno();
            a = (Aluno) dados.get(indice);

            texto += "\nNome: " + a.getNome();
            texto += " | Nota 1: " + a.getNota1();
            texto += " | Nota 2: " + a.getNota2();
            texto += " | Média: " + a.getMedia();
        }

        // Exibir mensagem
        JOptionPane.showMessageDialog(null, texto);

    }

    // Verificar o nome a ser cadastrado ou excluído
    private int verificaExistencia(String nome){

        // Variável
        int posicao = -1;

        // Laço
        for(int i=0; i<dados.size(); i++){
            Aluno a = new Aluno();
            a = (Aluno) dados.get(i);

            if(a.getNome().toLowerCase().equals(nome.toLowerCase())){
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
            JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }else{
            dados.remove(valida);
            JOptionPane.showMessageDialog(null, "Aluno removido com sucesso");
        }

    }

}
