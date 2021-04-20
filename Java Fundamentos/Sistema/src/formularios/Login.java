package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import dao.UsuarioDao;
import modelo.UsuarioModelo;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField pswSenha;
	private JPasswordField pswRepetirSenha;
	private JTextField txtEmailLogin;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel painelCadastro = new JPanel();
		painelCadastro.setBorder(new LineBorder(Color.GRAY));
		painelCadastro.setBounds(30, 30, 475, 555);
		contentPane.add(painelCadastro);
		painelCadastro.setLayout(null);
		
		JLabel lblCadastrar = new JLabel("Novo por aqui? Cadastre-se");
		lblCadastrar.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setBounds(6, 140, 463, 51);
		painelCadastro.add(lblCadastrar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/Users/ralf/Documents/Noturno/Java Fundamentos/Sistema/imagens/novoUsuario.png"));
		lblNewLabel.setBounds(164, 6, 128, 128);
		painelCadastro.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(15, 242, 440, 26);
		painelCadastro.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNome.setBounds(18, 224, 61, 16);
		painelCadastro.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEmail.setBounds(18, 292, 61, 16);
		painelCadastro.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(15, 310, 440, 26);
		painelCadastro.add(txtEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblSenha.setBounds(18, 359, 61, 16);
		painelCadastro.add(lblSenha);
		
		pswSenha = new JPasswordField();
		pswSenha.setColumns(10);
		pswSenha.setBounds(15, 377, 440, 26);
		painelCadastro.add(pswSenha);
		
		JLabel lblRepetirSenha = new JLabel("Repetir senha");
		lblRepetirSenha.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblRepetirSenha.setBounds(18, 427, 159, 16);
		painelCadastro.add(lblRepetirSenha);
		
		pswRepetirSenha = new JPasswordField();
		pswRepetirSenha.setColumns(10);
		pswRepetirSenha.setBounds(15, 445, 440, 26);
		painelCadastro.add(pswRepetirSenha);
		
		JButton btnCriarConta = new JButton("Criar conta");
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obter os dados
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String senha = String.valueOf(pswSenha.getPassword());
				String repetirSenha = String.valueOf(pswRepetirSenha.getPassword());
				
				// Validação
				if(nome.equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o campo nome");
				}else if(email.equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o campo e-mail");
				}else if(senha.equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o campo senha");
				}else if(repetirSenha.equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o campo repetir senha");
				}else if(!senha.equals(repetirSenha)) {
					JOptionPane.showMessageDialog(null, "As senhas precisam ser iguais");
				}else {
					
					try {
						UsuarioModelo obj = UsuarioDao.cadastrar(email, nome, senha);
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
						
						Painel p = new Painel(obj);
						p.setVisible(true);
						
						dispose();
					}catch(Exception erro) {
						JOptionPane.showMessageDialog(null, "Falha ao cadastrar");
					}
					
				}
				
			}
		});
		btnCriarConta.setBounds(164, 502, 117, 29);
		painelCadastro.add(btnCriarConta);
		
		JPanel painelLogin = new JPanel();
		painelLogin.setBorder(new LineBorder(Color.GRAY));
		painelLogin.setBounds(540, 30, 475, 555);
		contentPane.add(painelLogin);
		painelLogin.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/ralf/Documents/Noturno/Java Fundamentos/Sistema/imagens/login.png"));
		lblNewLabel_1.setBounds(164, 6, 128, 128);
		painelLogin.add(lblNewLabel_1);
		
		JLabel lblJTemConta = new JLabel("Já tem conta? Faça o login");
		lblJTemConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblJTemConta.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblJTemConta.setBounds(6, 140, 463, 51);
		painelLogin.add(lblJTemConta);
		
		JLabel lblEmailLogin = new JLabel("E-mail");
		lblEmailLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEmailLogin.setBounds(19, 224, 61, 16);
		painelLogin.add(lblEmailLogin);
		
		txtEmailLogin = new JTextField();
		txtEmailLogin.setColumns(10);
		txtEmailLogin.setBounds(16, 242, 440, 26);
		painelLogin.add(txtEmailLogin);
		
		JLabel lblSenhaLogin = new JLabel("Senha");
		lblSenhaLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblSenhaLogin.setBounds(19, 291, 61, 16);
		painelLogin.add(lblSenhaLogin);
		
		JPasswordField pswSenhaLogin = new JPasswordField();
		pswSenhaLogin.setColumns(10);
		pswSenhaLogin.setBounds(16, 309, 440, 26);
		painelLogin.add(pswSenhaLogin);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obter dados
				String email = txtEmailLogin.getText();
				String senha = String.valueOf(pswSenhaLogin.getPassword());
				
				// Validar campos
				if(email.equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o campo e-mail");
				}else if(senha.equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o campo senha");
				}else {
					int contador = 0;
					
					try {
						contador = UsuarioDao.validaLogin(email, senha);
						
						if(contador == 0) {
							JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
						}else {
							UsuarioModelo usuario = UsuarioDao.obterUsuario(email, senha);
							JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
							
							Painel p = new Painel(usuario);
							p.setVisible(true);
							
							dispose();
						}
						
					} catch (SQLException erro) {
						JOptionPane.showMessageDialog(null, "Falhar ao logar, tente novamente");
					}
					
				}
				
			}
		});
		btnAcessar.setBounds(175, 361, 117, 29);
		painelLogin.add(btnAcessar);
	}
}
