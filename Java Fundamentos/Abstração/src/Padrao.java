
public abstract class Padrao {
	
	// Vale Transporte
	public abstract void valeTransporte(double salario);
	
	// Vale Alimentação
	public abstract void valeAlimentacao(double salario);
	
	// Prêmio faltas
	public void premioFaltas(int faltas) {
		System.out.println(faltas == 0 ? "R$100,00" : "R$0,00");
	}
	

}
