package controle;

import javax.swing.table.DefaultTableModel;

import bd.Armazenar;
import modelo.Cliente;

public class Acao {
	
	// Cadastrar
	public static String cadastrar(Cliente c) {
		
		// Variável
		String retorno;
		
		// Validar
		if(c.getNome().equals("")) {
			retorno = "O campo nome precisa estar preenchido";
		}else if(c.getCidade().equals("")) {
			retorno = "O campo cidade precisa estar preenchido";
		}else if(c.getIdade() < 0 || c.getIdade() >= 130) {
			retorno = "O campo idade não condiz com o número preenchido";
		}else {
			Armazenar.vetor.add(c);
			retorno = "Cadastro realizado com sucesso";
		}
		
		// Retorno
		return retorno;
	}
	
	// Selecionar
	public static DefaultTableModel listar() {
		
		// Objeto DefaultTableModel
		DefaultTableModel dtm = new DefaultTableModel();
		
		// Colunas
		dtm.addColumn("Nome");
		dtm.addColumn("Cidade");
		dtm.addColumn("Idade");
		
		// Linhas
		for(int i=0; i<Armazenar.vetor.size(); i++) {
			dtm.addRow(new Object[]{
				Armazenar.vetor.get(i).getNome(),
				Armazenar.vetor.get(i).getCidade(),
				Armazenar.vetor.get(i).getIdade()
			});
		}
		
		// Retorno
		return dtm;
		
	}
	
	// Remover
	public static void remover(int linha) {
		
		Armazenar.vetor.remove(linha);
		
	}
	
	// Alterar
	public static void alterar(Cliente c, int posicao) {
		
		Armazenar.vetor.set(posicao, c);
		
	}
	
}


















