public class Criminoso extends Pessoa{
    protected String dataPrisao;
    protected String MotivoPrisao;

    public Criminoso(String nome, int idade, String tipo, String dataPrisao, String MotivoPrisao){
        super(nome,idade,tipo);
        this.dataPrisao = dataPrisao;
        this.MotivoPrisao = MotivoPrisao;
    }

    public void falar(){
        System.out.println("DAR PISTA UNICA PARA CADA CRIMINOSO.");
    }

}
