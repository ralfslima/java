package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.Conexao;
import modelo.UsuarioModelo;

public class UsuarioDao {

	// Cadastro
	public static UsuarioModelo cadastrar(String email, String nome, String senha) throws SQLException {
		
		// Objeto da classe UsuarioModelo
		UsuarioModelo obj = new UsuarioModelo();
		
		// Conexão
		Conexao.criarConexao();
		
		// SQL
		String sql = "INSERT INTO usuarios (emailUsuario, nomeUsuario, senhaUsuario) VALUES (?, ?, ?)";
		
		// Tentativa
		try {
			
			// Cadastro
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);                    
			pstmt.setString(1, email);
			pstmt.setString(2, nome);
			pstmt.setString(3, senha);
			pstmt.execute();
			
			// Obtêm o código do usuário
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.last();
			
			// Passar os atributos para nosso obj
			obj.setCodigo(rs.getInt(1));
			obj.setEmail(email);
			obj.setNome(nome);
			obj.setSenha(senha);
			
		}catch(Exception erro) {
			
			System.out.println("Falha ao cadastrar um usuário " + erro.getMessage());
			
		}finally {
			
			Conexao.finalizarConexao();
			
		}
		
		// Retorno
		return obj;
		
	}
	
	
	// Validar login
	public static int validaLogin(String email, String senha) throws SQLException {
		
		// Contador
		int contador = 0;
		
		// Conexão
		Conexao.criarConexao();
		
		// SQL
		String sql = "SELECT * FROM usuarios WHERE emailUsuario = ? AND senhaUsuario = ?";
		
		// Tentativa
		try {
			
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, senha);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				contador++;
			}
			
		}catch(Exception erro) {
			
		}finally {
			Conexao.finalizarConexao();
		}
		
		// Retorno
		return contador;
		
	}
	
	// Retornar todos os dados do usuário
	public static UsuarioModelo obterUsuario(String email, String senha) throws SQLException {
		
		// Objeto da classe UsuarioModelo
		UsuarioModelo obj = new UsuarioModelo();
		
		// Conexão
		Conexao.criarConexao();
		
		// SQL
		String sql = "SELECT * FROM usuarios WHERE emailUsuario = ? AND senhaUsuario = ?";
		
		// Tentativa
		try {
			
			// Seleção
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);                    
			pstmt.setString(1, email);
			pstmt.setString(2, senha);
			
			// Armazenar
			ResultSet rs = pstmt.executeQuery();
		
			// Passar os atributos para nosso obj
			while(rs.next()) {
				obj.setCodigo(rs.getInt(1));
				obj.setEmail(rs.getString(2));
				obj.setNome(rs.getString(3));
				obj.setSenha(rs.getString(4));
			}
			
		}catch(Exception erro) {
			
			System.out.println("Falha ao selecionar um usuário " + erro.getMessage());
			
		}finally {
			
			Conexao.finalizarConexao();
			
		}
		
		// Retorno
		return obj;

	}
	
	
	
	
	
}




