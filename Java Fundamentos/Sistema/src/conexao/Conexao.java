package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	// Atributos
	private final static String usuario = "root";
	private final static String senha = "root1234";
	private final static String base = "sistema";
	private final static String fuso = "?useTimezone=true&serverTimezone=UTC";
	private final static String caminho = "jdbc:mysql://localhost/";
	public static Connection conexao;
	
	// Criar a conexão
	public static void criarConexao() {
		
		// Tentativa
		try {
			conexao = DriverManager.getConnection(caminho+base+fuso, usuario, senha);
			
			System.out.println("Conexão ok");
		}catch(Exception erro) {
			System.out.println("Falha ao conectar " + erro.getMessage());
		}
		
	}
	
	// Finalizar a conexão
	public static void finalizarConexao() throws SQLException {
		conexao.close();
	}

}





