public class Serie {

    // Atributos
    private String nome, genero;
    private int temporada, classificacao;

    // Get
    public String getNome(){
        return this.nome;
    }
    public String getGenero(){
        return this.genero;
    }
    public int getTemporada(){
        return this.temporada;
    }
    public int getClassificacao(){
        return this.classificacao;
    }

    // Set
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public void setTemporada(int temporada){
        this.temporada = temporada;
    }
    public void setClassificacao(int classificacao){
        this.classificacao = classificacao;
    }

    
}