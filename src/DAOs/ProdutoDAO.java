/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Classes.Conexao;
import Classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gutof
 */
public class ProdutoDAO {
    public boolean cadastrar(Produto p) {
        String sql = "INSERT INTO produto (nome, preco, estoque, participante_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getEstoque());
            stmt.setInt(4, p.getParticipanteId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar produto: " + e.getMessage());
            return false;
        }
    }

    
    public List<Produto> listarPorParticipante(int participanteId) {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE participante_id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, participanteId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setEstoque(rs.getInt("estoque"));
                p.setParticipanteId(rs.getInt("participante_id"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        return lista;
    }

    
    public boolean excluir(int produtoId) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produtoId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao excluir produto: " + e.getMessage());
            return false;
        }
    }
    
    public boolean atualizar(Produto p) {
    String sql = "UPDATE produto SET nome = ?, preco = ?, estoque = ? WHERE id = ?";
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, p.getNome());
        stmt.setDouble(2, p.getPreco());
        stmt.setInt(3, p.getEstoque());
        stmt.setInt(4, p.getId());
        
        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.err.println("Erro ao atualizar produto: " + e.getMessage());
        return false;
    }
}
    
    
    public boolean realizarVenda(int produtoId, int quantidadeVendida) {
        String sqlSelect = "SELECT estoque FROM produto WHERE id = ?";
        String sqlUpdate = "UPDATE produto SET estoque = ? WHERE id = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect)) {
            
            stmtSelect.setInt(1, produtoId);
            ResultSet rs = stmtSelect.executeQuery();
            
            if (rs.next()) {
                int estoqueAtual = rs.getInt("estoque");
                if (estoqueAtual >= quantidadeVendida) {
                    int novoEstoque = estoqueAtual - quantidadeVendida;
                    
                    try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
                        stmtUpdate.setInt(1, novoEstoque);
                        stmtUpdate.setInt(2, produtoId);
                        stmtUpdate.executeUpdate();
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao realizar venda: " + e.getMessage());
        }
        return false;
    }
}
