package formularios;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.Armazenar;
import controle.Acao;
import modelo.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Formulario extends JFrame {

	// Elementos globais
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCidade;
	private JTextField txtIdade;
	private JTable table;
	private int linha;

	// Main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Formulário
	public Formulario() {
		
		// Configurações padrões do JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Elementos
		JScrollPane scrollPane = new JScrollPane();
		JLabel lblNome = new JLabel("Nome:");
		JLabel lblCidade = new JLabel("Cidade:");
		JLabel lblIdade = new JLabel("Idade:");
		JLabel lblImagem = new JLabel("New label");
		JButton btnCadastrar = new JButton("Cadastrar");
		JButton btnAlterar = new JButton("Alterar");
		JButton btnExcluir = new JButton("Excluir");
		JButton btnCancelar = new JButton("Cancelar");
		
		// Cadastrar
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obter os dados
				String nome = txtNome.getText();
				String cidade = txtCidade.getText();
				int idade = Integer.parseInt(txtIdade.getText());
				
				// Instanciar um objeto da classe Cliente
				Cliente c = new Cliente();
				c.setNome(nome);
				c.setCidade(cidade);
				c.setIdade(idade);
				
				// Executar o cadastro
				String resposta = Acao.cadastrar(c);
				
				// JOptionPane
				JOptionPane.showMessageDialog(null, resposta);
				
				// Atualizar tabela
				table.setModel(Acao.listar());
				
				// Limpar campos
				txtNome.setText("");
				txtCidade.setText("");
				txtIdade.setText("");
				
			}
		});
		
		// Excluir
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Executar a exclusão
				Acao.remover(linha);
				
				// Atualizar o JTable
				table.setModel(Acao.listar());
				
				// Botões
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnCancelar.setEnabled(false);
				
				// Limpar campos
				txtNome.setText("");
				txtCidade.setText("");
				txtIdade.setText("");
				
				// Mensagem
				JOptionPane.showMessageDialog(null, "Removido com sucesso");
			}
		});
		
		// Cancelar
		btnCancelar.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Botões
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnCancelar.setEnabled(false);
				
				// Limpar campos
				txtNome.setText("");
				txtCidade.setText("");
				txtIdade.setText("");
				
			}
		});
		
		// Alterar
		btnAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Obter os dados
				String nome = txtNome.getText();
				String cidade = txtCidade.getText();
				int idade = Integer.parseInt(txtIdade.getText());
				
				// Instanciar um objeto da classe Cliente
				Cliente c = new Cliente();
				c.setNome(nome);
				c.setCidade(cidade);
				c.setIdade(idade);
				
				// Executar a alteração
				Acao.alterar(c, linha);
				
				// JOptionPane
				JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
				
				// Atualizar tabela
				table.setModel(Acao.listar());
				
				// Limpar campos
				txtNome.setText("");
				txtCidade.setText("");
				txtIdade.setText("");
				
			}
		});
		
		// Evento para validar apenas números (idade)
		
		
		// JScrolPane, Tabela e DefaultTableModel
		scrollPane.setBounds(16, 318, 488, 189);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setModel(Acao.listar());
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				// Obter posição da linha
				linha = table.getSelectedRow();
				
				// Exibir os valores nos campos
				txtNome.setText(Armazenar.vetor.get(linha).getNome());
				txtCidade.setText(Armazenar.vetor.get(linha).getCidade());
				txtIdade.setText(String.valueOf(Armazenar.vetor.get(linha).getIdade()));
				
				// Botões
				btnCadastrar.setEnabled(false);
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnCancelar.setEnabled(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// Labels
		lblNome.setForeground(new Color(255, 0, 0));
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(69, 150, 61, 16);
		contentPane.add(lblNome);
		
		lblCidade.setForeground(Color.RED);
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCidade.setBounds(69, 185, 61, 16);
		contentPane.add(lblCidade);
	
		lblIdade.setForeground(Color.RED);
		lblIdade.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdade.setBounds(69, 222, 61, 16);
		contentPane.add(lblIdade);
		
		lblImagem.setIcon(new ImageIcon("/Users/ralf/Documents/Noturno/Java Fundamentos/Projeto01/lib/usuario.png"));
		lblImagem.setBounds(205, 6, 128, 128);
		contentPane.add(lblImagem);
	
		// JTexts
		txtNome = new JTextField();
		txtNome.setBounds(139, 146, 334, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(139, 181, 334, 26);
		contentPane.add(txtCidade);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(139, 218, 334, 26);
		contentPane.add(txtIdade);
		
		txtIdade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				// Obter o valor do campo de texto e a quantidade de caracteres
				String texto = txtIdade.getText();
				int qtdCaracteres = texto.length();
				
				// Verifica a quantidade de caracteres
				if(qtdCaracteres > 0) {

					// Se o código da última tecla estiver entre 49 e 58
					if(e.getKeyCode() < 49 || e.getKeyCode() > 58) {
						txtIdade.setText(texto.substring(0, qtdCaracteres - 1));
					}
					
				}
				
			}
		});
		
		// JButtons
		btnCadastrar.setBounds(6, 266, 117, 29);
		contentPane.add(btnCadastrar);
		
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(135, 266, 117, 29);
		contentPane.add(btnAlterar);

		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(264, 266, 117, 29);
		contentPane.add(btnExcluir);

		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(393, 266, 117, 29);
		contentPane.add(btnCancelar);
		
	}
}
