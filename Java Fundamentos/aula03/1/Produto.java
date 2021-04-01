public class Produto {

    // Atributos
    private String produto, marca;
    private double valor;

    // Get
    public String getProduto(){
        return this.produto;
    }
    public String getMarca(){
        return this.marca;
    }
    public double getValor(){
        return this.valor;
    }

    // Set
    public void setProduto(String produto){
        this.produto = produto;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setValor(double valor){
        this.valor = valor;
    }

    
}