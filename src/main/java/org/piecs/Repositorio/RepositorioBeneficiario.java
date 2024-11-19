package org.piecs.Repositorio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.piecs.InfraEstrutura.ConexaoBancoDados;
import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;
import org.piecs.Modelo.T_PIECS_ENDERECO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioBeneficiario implements RepositorioBase<T_PIECS_BENEFICIARIOS>{

    private static final Logger logger = LogManager.getLogger(RepositorioBeneficiario.class);

    @Override
    public void Adicionar(T_PIECS_BENEFICIARIOS beneficiario) {
        String query = "INSERT INTO T_PIECS_BENEFICIARIOS (nm_beneficiario, email, senha) VALUES (?,?,?) ";
        int generatedId = 0;

        try{
            Connection conn = ConexaoBancoDados.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, beneficiario.getId());
            stmt.setString(2, beneficiario.getNm_beneficiario());
            stmt.setString(3, beneficiario.getEmail());
            stmt.setString(4, beneficiario.getSenha());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T_PIECS_BENEFICIARIOS> Listar() {

        List<T_PIECS_BENEFICIARIOS> beneficiarios = new ArrayList<>();
        String query = "SELECT * FROM T_PIECS_BENEFICIARIOS";

        try (
            Connection conn = ConexaoBancoDados.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){

            while (rs.next()) {
                T_PIECS_BENEFICIARIOS beneficiario = new T_PIECS_BENEFICIARIOS(
                        rs.getInt("id_beneficiario"),
                        false,
                        rs.getString("nm_beneficiario"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                T_PIECS_BENEFICIARIOS.add(beneficiario);
            }
        } catch (SQLException e) {
            logger.error("Erro ao listar beneficiario: " + e.getMessage(), e);
        }
        return beneficiarios;
    }

    @Override
    public void Delete(String id) {
        String query = "DELETE FROM T_PIECS_BENEFICIARIOS WHERE id_beneficiario = ?";

        try (Connection conn = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1,id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Beneficiário removido com sucesso com ID: " + id);
            } else {
                logger.warn("Nenhum beneficiário encontrado para remover com ID: " + id);
            }
        } catch (SQLException e) {
            logger.error("Erro ao remover beneficiário com ID " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public void UpDate(T_PIECS_BENEFICIARIOS beneficiario) {

        String query = "UPDATE T_PIECS_BENEFICIARIOS SET nm_beneficiario = ?, email = ?, senha = ? WHERE id_beneficiario = ? ";

        try (Connection conn = ConexaoBancoDados.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, beneficiario.getId());
            stmt.setString(2, beneficiario.getNm_beneficiario());
            stmt.setString(3, beneficiario.getEmail());
            stmt.setString(4, beneficiario.getSenha());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Beneficiario atualizado com sucesso: " + beneficiario.getNm_beneficiario());
            } else {
                logger.warn("Nenhum beneficiario encontrado para atualizar com ID: " + beneficiario.getId());
            }
        } catch (SQLException e) {
            logger.error("Erro ao atualizar beneficiario com ID " + beneficiario.getId() + ": " + e.getMessage(), e);
        }

    }

    @Override
    public T_PIECS_BENEFICIARIOS GetById(String id) {
        String query = "SELECT * FROM T_PIECS_BENEFICIARIOS WHERE id_beneficiario = ?";

        try (Connection conn = ConexaoBancoDados.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    return new T_PIECS_BENEFICIARIOS(
                            rs.getInt("id"),
                            rs.getString("nm_beneficiario"),
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                } else{
                    logger.warn("Nenhum beneficiario encontrado com o ID: " + id);
                }
            } catch (SQLException e){
                logger.error("Erro ao buscar beneficiario por ID " + id + e.getMessage(), e);
            }
            return null;
        }
    }

    @Override
    public List<T_PIECS_BENEFICIARIOS> GetAll() {
        return RepositorioBase.super.GetAll();
    } else {
        System.out.println("Erro ao adicionar beneficiario");
        }
    }

}
