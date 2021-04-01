// Classe (molde)
public class Carro{

    // Atributos (características)
    public String fabricante, modelo;
    public int ano;
    public double valor;
    public boolean tetoSolar;

    // Métodos (ações)
    public void mensagem(){
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Valor: R$" + valor);
        System.out.println("Possui teto solar: " + (tetoSolar == true ? "Sim" : "Não"));
    }

}