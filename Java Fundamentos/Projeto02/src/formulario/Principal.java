package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtNota2;
	private JTextField txtNota1;
	private JTextField txtMedia;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNome.setBounds(21, 32, 61, 16);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblIdade.setBounds(21, 71, 61, 16);
		contentPane.add(lblIdade);
		
		JLabel lblNota1 = new JLabel("Nota 1");
		lblNota1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNota1.setBounds(21, 114, 61, 16);
		contentPane.add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2");
		lblNota2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNota2.setBounds(21, 157, 61, 16);
		contentPane.add(lblNota2);
		
		JLabel lblMedia = new JLabel("Média");
		lblMedia.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblMedia.setBounds(21, 196, 61, 16);
		contentPane.add(lblMedia);
		
		txtNome = new JTextField();
		txtNome.setBounds(77, 28, 458, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(77, 67, 458, 26);
		contentPane.add(txtIdade);
		
		txtNota2 = new JTextField();
		txtNota2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				// Tentiva
				try {
				
					// Obter as notas
					double nota1 = Double.parseDouble(txtNota1.getText());
					double nota2 = Double.parseDouble(txtNota2.getText());
					
					// Realizar a média
					double media = (nota1 + nota2) / 2;
					
					// Exibir a média
					txtMedia.setText(String.valueOf(media));
				
				}catch(Exception erro) {
					txtMedia.setText("");
				}
				
			}
		});
		txtNota2.setColumns(10);
		txtNota2.setBounds(77, 147, 458, 26);
		contentPane.add(txtNota2);
		
		txtNota1 = new JTextField();
		txtNota1.setColumns(10);
		txtNota1.setBounds(77, 108, 458, 26);
		contentPane.add(txtNota1);
		
		txtMedia = new JTextField();
		txtMedia.setEnabled(false);
		txtMedia.setColumns(10);
		txtMedia.setBounds(77, 188, 458, 26);
		contentPane.add(txtMedia);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(21, 242, 117, 29);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(146, 242, 117, 29);
		contentPane.add(btnAlterar);
		
		JButton btmExcluir = new JButton("Excluir");
		btmExcluir.setEnabled(false);
		btmExcluir.setBounds(275, 242, 117, 29);
		contentPane.add(btmExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(411, 242, 117, 29);
		contentPane.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 294, 513, 198);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
