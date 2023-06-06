public abstract class Pessoa {
    protected String nome;

    protected String sobrenome;

    protected int idade;

    protected String tipo;

    public Pessoa(String nome, int idade, String tipo) {
        this.nome= nome;
        this.idade = idade;
        this.tipo = tipo;
    }

    public abstract void falar();
}
