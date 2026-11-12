package Classes;

/**
 *
 * @author Gutof
 */
public class Vendedor extends Participante {
    public Vendedor() {
        setTipo("VENDEDOR");
    }

    public Vendedor(String nome, String documento, String email, String ramoVendas, String tipo) {
        super(nome, documento, email, ramoVendas, tipo);
    }

   
}
