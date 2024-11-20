package org.piecs.Repositorio;

import org.piecs.InfraEstrutura.ConexaoBancoDados;
import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;
import org.piecs.Modelo.T_PIECS_RESPONSAVEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositorioBeneficiario implements RepositorioBase<T_PIECS_BENEFICIARIOS> {

    @Override
    public void Adicionar(T_PIECS_BENEFICIARIOS beneficiarios) {
        String query = "INSERT INTO T_PIECS_BENEFICIARIOS (nm_beneficiario, email, senha) VALUES (?,?,?)";
        try (Connection conn = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, beneficiarios.getNm_beneficiario());
            stmt.setString(2, beneficiarios.getEmail());
            stmt.setString(3, beneficiarios.getSenha());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Listar() {
        String query = "SELECT * FROM T_PIECS_BENEFICIARIOS";
        try (Connection conn = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                var rsId = rs.getString("id");
                var rsBeneficiario = rs.getString("nm_beneficiario");
                var rsEmail = rs.getString("email");
                var rsSenha = rs.getString("senha");
                System.out.println("id: " + rsId + ", nm_beneficiario: " + rsBeneficiario + ", email: " + rsEmail + ", senha: " + rsSenha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(String id) {
        String query = "DELETE FROM T_PIECS_BENEFICIARIOS WHERE id = ?";
        try (Connection conn = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpDate(T_PIECS_BENEFICIARIOS beneficiario) {
        String query = "UPDATE T_PIECS_BENEFICIARIOS SET nm_beneficiario = ?, email = ? WHERE id = ?";
        try (Connection conn = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, beneficiario.getNm_beneficiario());
            stmt.setString(2, beneficiario.getEmail());
            stmt.setString(3, beneficiario.getId()); // Verifique se getId() está definido
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T_PIECS_BENEFICIARIOS GetById(String id) {
        T_PIECS_BENEFICIARIOS beneficiario = null;
        String query = "SELECT * FROM T_PIECS_BENEFICIARIOS WHERE id = ?";
        try (Connection conn = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    var rsId = rs.getString("id");
                    var rsBeneficiario = rs.getString("nm_beneficiario");
                    beneficiario = new T_PIECS_BENEFICIARIOS(rsId, rsBeneficiario);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beneficiario;
    }

    public List<T_PIECS_BENEFICIARIOS> ListarPorResponsavel(String responsavelId, int pageSize) {
        List<T_PIECS_BENEFICIARIOS> beneficiarios = new ArrayList<>();
        String query = "SELECT * FROM T_PIECS_BENEFICIARIOS WHERE responsavel_id = ? LIMIT ?";
        try (Connection conn = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, responsavelId);
            stmt.setInt(2, pageSize);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    var rsId = rs.getString("id");
                    var rsBeneficiario = rs.getString("nm_beneficiario");
                    var rsEmail = rs.getString("email");
                    var rsSenha = rs.getString("senha");
                    // Supondo que você tenha um método para obter o responsável
                    T_PIECS_RESPONSAVEL responsavel = obterResponsavelPorId(rs.getString("responsavel_id"));
                    beneficiarios.add(new T_PIECS_BENEFICIARIOS(rsId, rsBeneficiario, rsEmail, rsSenha, responsavel));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beneficiarios;
    }

    private T_PIECS_RESPONSAVEL obterResponsavelPorId(String responsavelId) {
        T_PIECS_RESPONSAVEL responsavel = null;
        String query = "SELECT * FROM T_PIECS_RESPONSAVEL WHERE id = ?"; // Supondo que a tabela se chama T_PIECS_RESPONSAVEL
        try (Connection conn = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, responsavelId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Supondo que a tabela T_PIECS_RESPONSAVEL tenha os campos id e nome
                    var rsNome = rs.getString("nome"); // Altere conforme os campos reais da tabela
                    responsavel = new T_PIECS_RESPONSAVEL(responsavelId, rsNome); // Supondo que você tenha um construtor que aceita ID e nome
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responsavel;
    }
}


