package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import conexao.Conexao;
import modelo.ContatoModelo;

public class ContatoDao {
	
	// Cadastrar
	public static void cadastrar(ContatoModelo c) throws SQLException {
		
		// Obter conexão
		Conexao.criarConexao();
		
		// SQL
		String sql = "INSERT INTO contatos (nomeContato, emailContato, enderecoContato, telefoneContato, comentarioContato, codigoUsuario) VALUES (?,?,?,?,?,?)";
		
		// Realizar cadastro
		try {
			
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setString(1, c.getNome());
			pstmt.setString(2, c.getEmail());
			pstmt.setString(3, c.getEndereco());
			pstmt.setString(4, c.getTelefone());
			pstmt.setString(5, c.getComentario());
			pstmt.setInt(6, c.getCodigoUsuario());
			pstmt.execute();
			
		}catch(Exception erro) {
			
			System.out.println("Falha ao cadastrar " + erro.getMessage());
			
		}finally {
			Conexao.finalizarConexao();
		}
	
	}
	
	// Selecionar
	public static DefaultTableModel listar(int codigoUsuario) throws SQLException {
		
		// Objeto DefaultTableModel
		DefaultTableModel dtm = new DefaultTableModel();

		// Colunas
		dtm.addColumn("Nome");
		dtm.addColumn("E-mail");
		dtm.addColumn("Endereço");
		dtm.addColumn("Telefone");
		dtm.addColumn("Comentário");
		
		// Obter conexão
		Conexao.criarConexao();
		
		// SQL
		String sql = "SELECT * FROM contatos WHERE codigoUsuario = ?";
		
		// Realizar cadastro
		try {
			
			// Preparar o comando SQL
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setInt(1, codigoUsuario);
			
			// Obter resultado do SQL
			ResultSet rs = pstmt.executeQuery();
			
			
			// Adicionar contatos no DefaultTableModel
			while(rs.next()) {
				dtm.addRow(new Object[] {
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6)
				});
			}
			
			
		}catch(Exception erro) {
			
			System.out.println("Falha ao listar " + erro.getMessage());
			
		}finally {
			Conexao.finalizarConexao();
		}
		
		
		// Retorno
		return dtm;
		
	}

}
