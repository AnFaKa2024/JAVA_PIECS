package org.piecs.Repositorio;

import org.piecs.InfraEstrutura.ConexaoBancoDados;
import org.piecs.Modelo.T_PIECS_RESPONSAVEL;


public class RepositorioReponsavel implements RepositorioBase<T_PIECS_RESPONSAVEL>{


    @Override
    public void Adicionar(T_PIECS_RESPONSAVEL responsavel) {
        String query = "INSERT INTO T_PIECS_RESPONSAVEL (nm_cliente, dt_nascimento, cpf_cnpj, email, senha, qt_armazenada_total, beneficiarios, enderecos) VALUES (?,?,?,?,?,?,?,?)";
        try (var conn = ConexaoBancoDados.getConnection();
             var stmt = conn.prepareStatement(query)) {

            stmt.setString(1, responsavel.getNm_cliente());
            stmt.setDate(2, java.sql.Date.valueOf(responsavel.getDt_nascimento()));
            stmt.setString(3, responsavel.getCpf_cnpj());
            stmt.setString(4, responsavel.getEmail());
            stmt.setString(5, responsavel.getSenha());
            stmt.setInt(6, responsavel.getQt_armazenada_total());
            stmt.setObject(7, responsavel.getBeneficiarios());
            stmt.setObject(8, responsavel.getEnderecos());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Listar() {
        String query = "SELECT * FROM T_PIECS_RESPONSAVEL";
        try (var conn = ConexaoBancoDados.getConnection();
             var stmt = conn.prepareStatement(query);
             var rs = stmt.executeQuery()) {

            while (rs.next()) {
                var rsId = rs.getInt("id");
                var nm_cliente = rs.getString("nm_cliente");
                var dt_nascimento = rs.getDate("dt_nascimento");
                var cpf_cnpj = rs.getString("cpf_cnpj");
                var email = rs.getString("email");
                var senha = rs.getString("senha");
                var qt_armazenada_total = rs.getInt("qt_armazenada_total");
                System.out.println("id" + rsId + "| nm_cliente" + nm_cliente + "| cpf_cnpj" + cpf_cnpj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(String id) {
        String query = "DELETE FROM T_PIECS_RESPONSAVEL WHERE id = ?";
        try (var conn = ConexaoBancoDados.getConnection();
             var stmt = conn.prepareStatement(query)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T_PIECS_RESPONSAVEL GetById(String id) {
        T_PIECS_RESPONSAVEL responsavel = null;
        String query = "SELECT * FROM T_PIECS_RESPONSAVEL WHERE id = ?";
        try (var conn = ConexaoBancoDados.getConnection();
             var stmt = conn.prepareStatement(query)) {

            stmt.setString(1, id);
            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    var rsId = rs.getString("id");
                    var rsCliente = rs.getString("nm_cliente");
                    var rsDtNascimento = rs.getDate("dt_nascimento");
                    var rsBeneficiarios = rs.getObject("beneficiarios");
                    var rsEnderecos = rs.getObject("enderecos");
                    responsavel = new T_PIECS_RESPONSAVEL(rsId, rsCliente, rsDtNascimento, rsBeneficiarios, rsEnderecos);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responsavel;
    }


}
