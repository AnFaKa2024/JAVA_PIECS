package org.piecs.Repositorio;

import org.piecs.InfraEstrutura.ConexaoBancoDados;
import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;
import org.piecs.Modelo.T_PIECS_ENDERECO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEndereco implements RepositorioBase<T_PIECS_ENDERECO>{


    @Override
    public void Adicionar(T_PIECS_ENDERECO endereco) {

        String query = "INSERT INTO T_PIECS_ENDERECO (id, cep, rua, bairro, cidade, estado, numero) VALUES (?,?,?,?,?,?,?)";
        try (java.sql.Connection conn = ConexaoBancoDados.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, endereco.getId());
            stmt.setString(2, endereco.getCep());
            stmt.setString(3, endereco.getRua());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());
            stmt.setInt(7, endereco.getNumero());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar endereço: " + e.getMessage());
        }
    }


    @Override
    public List<T_PIECS_ENDERECO> Listar() {
        List<T_PIECS_ENDERECO> enderecos = new ArrayList<>();
        String query = "SELECT * FROM T_PIECS_ENDERECO";
        try (java.sql.Connection conn = ConexaoBancoDados.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(query);
             java.sql.ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String rsId = rs.getString("id");
                String rsCep = rs.getString("cep");
                String rsRua = rs.getString("rua");
                String rsBairro = rs.getString("bairro");
                String rsCidade = rs.getString("cidade");
                String rsEstado = rs.getString("estado");
                int rsNumero = rs.getInt("numero");
                T_PIECS_ENDERECO endereco = new T_PIECS_ENDERECO(rsId, rsCep, rsRua, rsBairro, rsCidade, rsEstado, rsNumero);
                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar endereços: " + e.getMessage());
        }
        return enderecos;
    }

    @Override
    public void Delete(String id) {
        String query = "DELETE FROM T_PIECS_ENDERECO WHERE id = ?";
        try (java.sql.Connection conn = ConexaoBancoDados.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar endereço: " + e.getMessage());
        }
    }

    @Override
    public void UpDate() {

    }

    @Override
    public void UpDate(T_PIECS_BENEFICIARIOS beneficiario) {

    }


    @Override
    public T_PIECS_ENDERECO GetById(String id) {
        T_PIECS_ENDERECO endereco = null;
        String query = "SELECT * FROM T_PIECS_ENDERECO WHERE id = ?";
        try (java.sql.Connection conn = ConexaoBancoDados.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);
            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String rsId = rs.getString("id");
                    String rsCep = rs.getString("cep");
                    endereco = new T_PIECS_ENDERECO(rsId, rsCep);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar endereço por ID: " + e.getMessage());
        }
        return endereco;
    }

    public List<T_PIECS_ENDERECO> SearchByDescription(String descricao) {
        List<T_PIECS_ENDERECO> enderecos = new ArrayList<>();
        String query = "SELECT * FROM T_PIECS_ENDERECO WHERE rua LIKE ? OR bairro LIKE ? OR cidade LIKE ?";

        try (java.sql.Connection conn = ConexaoBancoDados.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(query)) {
            String searchPattern = "%" + descricao + "%"; // Adiciona os caracteres de wildcard para busca
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            stmt.setString(3, searchPattern);
            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String rsId = rs.getString("id");
                    String rsCep = rs.getString("cep");
                    String rsRua = rs.getString("rua");
                    String rsBairro = rs.getString("bairro");
                    String rsCidade = rs.getString("cidade");
                    String rsEstado = rs.getString("estado");
                    int rsNumero = rs.getInt("numero");
                    T_PIECS_ENDERECO endereco = new T_PIECS_ENDERECO(rsId, rsCep, rsRua, rsBairro, rsCidade, rsEstado, rsNumero);
                    enderecos.add(endereco);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar endereços por descrição: " + e.getMessage());
        }
        return enderecos;
    }
}