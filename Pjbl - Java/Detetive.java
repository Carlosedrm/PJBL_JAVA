import java.util.ArrayList;

public class Detetive extends Pessoa {
    private ArrayList<String> pistas;

    public Detetive(String nome, int idade, String tipo){
        super(nome,idade,tipo);
    }

    public void falar(){
        System.out.println("As suas pistas atuais são: ");
        for (String elemento : pistas) {
            System.out.println(elemento);
        }
    }
    
}