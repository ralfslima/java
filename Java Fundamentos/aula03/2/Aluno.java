public class Aluno {

    // Atributos
    private String nome;
    private double nota1, nota2, media;

    // Get
    public String getNome(){
        return this.nome;
    }
    public double getNota1(){
        return this.nota1;
    }
    public double getNota2(){
        return this.nota2;
    }
    public double getMedia(){
        return this.media;
    }

    // Set
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setNota1(double nota1){
        this.nota1 = nota1;
    }
    public void setNota2(double nota2){
        this.nota2 = nota2;
    }
    public void setMedia(double media){
        this.media = media;
    }

}