package DAOs;

import Classes.Conexao;
import Classes.Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gutof
 */
public class ParticipanteDAO {
    
    public int cadastrar(Participante p) {
        String sql = "INSERT INTO participante (nome, documento, email, ramo_vendas, tipo) VALUES (?, ?, ?, ?, ?)";
        int idGerado = -1;
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDocumento());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getRamoVendas());
            stmt.setString(5, p.getTipo());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
       } catch (SQLException e) {
        System.err.println("Erro ao cadastrar participante: " + e.getMessage());
    }
    return idGerado;
    }

    public Participante buscarPorId(int id) {
        String sql = "SELECT * FROM participante WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Participante p = new Participante();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDocumento(rs.getString("documento"));
                p.setEmail(rs.getString("email"));
                p.setRamoVendas(rs.getString("ramo_vendas"));
                p.setTipo(rs.getString("tipo"));
                return p;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar participante: " + e.getMessage());
        }
        return null;
    }
    
    public Participante buscarPorDocumento(String documento) {
    String sql = "SELECT * FROM participante WHERE documento = ?";
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, documento);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Participante p = new Participante();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDocumento(rs.getString("documento"));
            p.setEmail(rs.getString("email"));
            p.setRamoVendas(rs.getString("ramo_vendas"));
            p.setTipo(rs.getString("tipo"));
            return p;
        }
    } catch (SQLException e) {
        System.err.println("Erro ao buscar participante por documento: " + e.getMessage());
    }
    return null; // Retorna null se não encontrar
}

    public boolean atualizar(Participante p) {
        String sql = "UPDATE participante SET nome = ?, documento = ?, email = ?, ramo_vendas = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDocumento());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getRamoVendas());
            stmt.setInt(5, p.getId());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar participante: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM participante WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao excluir participante: " + e.getMessage());
            return false;
        }
    }
}
