
package Classes;

/**
 *
 * @author Gutof
 */
public class Participante {
    private int id;
    private String nome;
    private String documento; 
    private String email;
    private String ramoVendas;
    private String tipo;
    
    public Participante() {}
    
    public Participante(String nome, String documento, String email, String ramoVendas, String tipo) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.ramoVendas = ramoVendas;
        this.tipo = tipo;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getRamoVendas() {
        return ramoVendas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRamoVendas(String ramoVendas) {
        this.ramoVendas = ramoVendas;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
