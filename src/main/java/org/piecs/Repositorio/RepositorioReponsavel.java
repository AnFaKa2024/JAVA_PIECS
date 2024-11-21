package org.piecs.Repositorio;

import org.piecs.InfraEstrutura.ConexaoBancoDados;
import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;
import org.piecs.Modelo.T_PIECS_ENDERECO;
import org.piecs.Modelo.T_PIECS_RESPONSAVEL;

import java.util.List;


public class RepositorioReponsavel implements RepositorioBase<T_PIECS_RESPONSAVEL>{


    @Override
    public void Adicionar(T_PIECS_RESPONSAVEL responsavel) {
        String query = "INSERT INTO T_PIECS_RESPONSAVEL (nm_cliente, dt_nascimento, cpf_cnpj, email, senha, qt_armazenada_total) VALUES (?,?,?,?,?,?)";
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
    public List<T_PIECS_ENDERECO> Listar() {
        String query = "SELECT * FROM T_PIECS_RESPONSAVEL";
        try (var conn = ConexaoBancoDados.getConnection();
             var stmt = conn.prepareStatement(query);
             var rs = stmt.executeQuery()) {

            while (rs.next()) {
                var rsId = rs.getInt("id_responsavel");
                var nm_cliente = rs.getString("nm_cliente");
                var dt_nascimento = rs.getDate("dt_nascimento");
                var cpf_cnpj = rs.getString("cpf_cnpj");
                var email = rs.getString("email");
                var senha = rs.getString("senha");
                var qt_armazenada_total = rs.getInt("qt_armazenada_total");
                System.out.println("id" + rsId + "| nm_cliente" + nm_cliente + "| cpf_cnpj" + cpf_cnpj);
                System.out.println("Data de Nascimento: " + dt_nascimento);
                System.out.println("Email: " + email);
                System.out.println("Senha: " + senha);
                System.out.println("Quantidade Armazenada Total: " + qt_armazenada_total);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
    public void UpDate() {
    }

    @Override
    public void UpDate(T_PIECS_BENEFICIARIOS beneficiario) {
    }

    @Override
    public T_PIECS_RESPONSAVEL GetById(String id) {
        T_PIECS_RESPONSAVEL responsavel = null;
        String query = "INSERT INTO T_PIECS_RESPONSAVEL (nm_cliente, dt_nascimento, cpf_cnpj, email, senha, qt_armazenada_total) VALUES (?,?,?,?,?,?)";
        try (var conn = ConexaoBancoDados.getConnection();
             var stmt = conn.prepareStatement(query)) {

            stmt.setString(1, id);
            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    var rsId = rs.getInt("id_responsavel");
                    var rsCliente = rs.getString("nm_cliente");
                    var rsDtNascimento = rs.getDate("dt_nascimento");
                    var rsBeneficiarios = rs.getObject("id_beneficiario");
                    var rsEnderecos = rs.getObject("id_endereco");
                    responsavel = new T_PIECS_RESPONSAVEL(rsId, rsCliente);
                    System.out.println("Data de Nascimento: " + rsDtNascimento);
                    System.out.println("Beneficiários: " + rsBeneficiarios);
                    System.out.println("Endereços: " + rsEnderecos);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responsavel;
    }


}
