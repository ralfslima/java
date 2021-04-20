package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ContatoDao;
import modelo.ContatoModelo;
import modelo.UsuarioModelo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Painel extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Painel(UsuarioModelo usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Boa noite " + usuario.getNome());
		lblNewLabel.setBounds(20, 16, 204, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(40, 80, 61, 16);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(40, 112, 61, 16);
		contentPane.add(lblEmail);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(40, 147, 61, 16);
		contentPane.add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(40, 184, 61, 16);
		contentPane.add(lblTelefone);
		
		JLabel lblComentario = new JLabel("Comentário");
		lblComentario.setBounds(40, 215, 81, 16);
		contentPane.add(lblComentario);
		
		txtNome = new JTextField();
		txtNome.setBounds(118, 70, 352, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(118, 103, 352, 26);
		contentPane.add(txtEmail);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(118, 137, 352, 26);
		contentPane.add(txtEndereco);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(118, 174, 352, 26);
		contentPane.add(txtTelefone);
		
		JTextArea txtComentario = new JTextArea();
		txtComentario.setBounds(120, 215, 350, 77);
		contentPane.add(txtComentario);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Instanciar objeto da classe ContatoModelo
				ContatoModelo c = new ContatoModelo();
				
				// Obter dados
				c.setNome(txtNome.getText());
				c.setEmail(txtEmail.getText());
				c.setEndereco(txtEndereco.getText());
				c.setTelefone(txtTelefone.getText());
				c.setComentario(txtComentario.getText());
				c.setCodigoUsuario(usuario.getCodigo());
				
				// Efetucar o cadastro
				try {
					ContatoDao.cadastrar(c);
					JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso");
					
					table.setModel(ContatoDao.listar(usuario.getCodigo()));
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar o contato");
				}
				
			}
		});
		btnCadastrar.setBounds(191, 304, 117, 29);
		contentPane.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 350, 421, 214);
		contentPane.add(scrollPane);
		
		table = new JTable();
		try {
			table.setModel(ContatoDao.listar(usuario.getCodigo()));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scrollPane.setViewportView(table);
	}
}
