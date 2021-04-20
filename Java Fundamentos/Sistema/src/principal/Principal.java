package principal;

import java.awt.EventQueue;
import formularios.Login;

public class Principal {

	public static void main(String[] args) {
		
		//Conexao.criarConexao();
//		try {
//			UsuarioModelo obj = UsuarioDao.cadastrar("luciana.passos@gmail.com", "Luciana", "aabb");
//			System.out.println(obj.getCodigo());
//		
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		
		EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
					Login frame = new Login();
						frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
					}
			}
			});
		}
	
}
