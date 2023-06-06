import java.io.*;

public class Queima implements Serializable {
    private String descricao = "";

    public Queima(String descricao){
        this.descricao = descricao;
    }

    public void exibir(){
        System.out.println("A pista é: ");
        System.out.println(descricao);
    }

    public void salvar(String nome_arquivo) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nome_arquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(this);

        gravador.close();
        arquivo.close();
    }

    public static Queima2 abrir(String nome_arquivo) throws IOException, ClassNotFoundException {
        Queima2 queimar = null;
        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        queimar = (Queima2) restaurador.readObject();

        restaurador.close();
        arquivo.close();

        return queimar;
    }

}
