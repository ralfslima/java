
public class Analista extends Padrao{
	
	// Construtor
	public Analista(double salario, int faltas) {
		valeTransporte(salario);
		valeAlimentacao(salario);
		premioFaltas(faltas);
	}
	
	@Override
	public void valeTransporte(double salario) {
		System.out.println(salario > 5000 ? salario * 0.05 : salario * 0.03);
	}

	@Override
	public void valeAlimentacao(double salario) {
		System.out.println(salario > 5000 ? salario * 0.15 : salario * 0.10);
	}



}
