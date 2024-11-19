package org.piecs.Repositorio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.piecs.InfraEstrutura.ConexaoBancoDados;
import org.piecs.Modelo.T_PIECS_ENDERECO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RepositorioEndereco implements RepositorioBase<T_PIECS_ENDERECO>{

    @Override
    public void Adicionar(T_PIECS_ENDERECO endereco) {

        private static final Logger logger = LogManager.getLogger(RepositorioEndereco.class);

        String query = "INSERT INTO T_PIECS_ENDERECO (cep, rua, bairro, cidade, estado, numero) VALUES (?,?,?,?,?,?)";
        int generatedId = 0;

        try (Connection conn = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setInt(6, endereco.getNumero());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1);
                        endereco.setId(generatedId);
                        logger.info("Endereço cadastrado com sucesso com ID: " + generatedId);
                    }
                }

            }
        }
    }


    @Override
    public void Listar() {

        List<T_PIECS_ENDERECO> enderecos = new ArrayList<>();
        String sql = "SELECT * FROM T_PIECS_ENDERECO";

        try (Connection conexao = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                T_PIECS_ENDERECO endereco = new T_PIECS_ENDERECO(
                        rs.getString("id_endereco"),
                        false,
                        rs.getString("cep"),
                        rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("numero"),
                );
                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            logger.error("Erro ao listar endereços: " + e.getMessage(), e);
        }
        return enderecos;
        }


    }

    @Override
    public void Delete(String id) {

        String sql = "DELETE FROM T_FGK_ENDERECO WHERE id_endereco = ?";

        try (Connection conexao = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Endereço removido com sucesso com ID: " + id);
            } else {
                logger.warn("Nenhum endereço encontrado para remover com ID: " + id);
            }
        } catch (SQLException e) {
            logger.error("Erro ao remover endereço com ID " + id + ": " + e.getMessage(), e);
        }

    }

    @Override
    public void UpDate(T_PIECS_ENDERECO endereco) {
        String sql = "UPDATE T_PIECS_ENDERECO SET cep = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, numero = ?  WHERE id_endereco = ?";

        try (Connection conexao = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setInt(6, endereco.getNumero());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Endereço atualizado com sucesso: " + endereco.getCep());
            } else {
                logger.warn("Nenhum endereço encontrado para atualizar com ID: " + endereco.getId());
            }
        } catch (SQLException e) {
            logger.error("Erro ao atualizar endereço com ID " + endereco.getId() + ": " + e.getMessage(), e);
        }

    }

    @Override
    public T_PIECS_ENDERECO GetById(String id) {

        String sql = "SELECT * FROM T_PIECS_ENDERECO WHERE id_endereco = ?";

        try (Connection conexao = ConexaoBancoDados.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new T_PIECS_ENDERECO(
                            rs.getInt("id_endereco"),
                            false,
                            rs.getString("cep"),
                            rs.getString("rua"),
                            rs.getString("bairro"),
                            rs.getString("cidade"),
                            rs.getString("estado"),
                            rs.getString("numero"),
                    );
                } else {
                    logger.warn("Nenhum endereço encontrado com ID: " + id);
                }
            }
        } catch (SQLException e) {
            logger.error("Erro ao buscar endereço por ID " + id + ": " + e.getMessage(), e);
        }
        return null;



    }

}
