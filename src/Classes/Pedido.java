package Classes;

/**
 *
 * @author Gutof
 */
public class Pedido {
    private int id;
    private String dataPedido;
    private double valorTotal;
    private int participanteId; 

    public Pedido() {}

    public Pedido(double valorTotal, int participanteId) {
        this.valorTotal = valorTotal;
        this.participanteId = participanteId;
    }

    public int getId() {
        return id;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getParticipanteId() {
        return participanteId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setParticipanteId(int participanteId) {
        this.participanteId = participanteId;
    }
    
    
}
