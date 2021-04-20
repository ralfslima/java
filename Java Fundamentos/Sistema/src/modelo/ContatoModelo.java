package modelo;

public class ContatoModelo {
	
	// Atributos
	private int codigoContato, codigoUsuario;
	private String nome, email, endereco, telefone, comentario;
	
	// Get e Set
	public int getCodigoContato() {
		return codigoContato;
	}
	public void setCodigoContato(int codigoContato) {
		this.codigoContato = codigoContato;
	}
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	
}
