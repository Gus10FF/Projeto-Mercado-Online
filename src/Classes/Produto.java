package Classes;

/**
 *
 * @author Gutof
 */
public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int estoque;
    private int participanteId;
    
    public Produto() {}
    
    public Produto(String nome, double preco, int estoque, int participanteId) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.participanteId = participanteId;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public int getParticipanteId() {
        return participanteId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setParticipanteId(int participanteId) {
        this.participanteId = participanteId;
    }
    
    
}