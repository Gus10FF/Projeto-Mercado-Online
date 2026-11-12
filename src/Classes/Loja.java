package Classes;

/**
 *
 * @author Gutof
 */
public class Loja extends Participante {

    public Loja() {
        setTipo("LOJA");
    }

    public Loja(String nome, String documento, String email, String ramoVendas, String tipo) {
        super(nome, documento, email, ramoVendas, tipo);
    }
    
}
