package org.piecs.Repositorio;

import org.piecs.InfraEstrutura.ConexaoBancoDados;
import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;
import org.piecs.Modelo.T_PIECS_ENDERECO;


import java.util.List;


public class RepositorioBeneficiario implements RepositorioBase<T_PIECS_BENEFICIARIOS> {


    @Override
    public void Adicionar(T_PIECS_BENEFICIARIOS beneficiarios) {
        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "INSERT INTO T_PIECS_BENEFICIARIOS (nm_beneficiario, email, senha) VALUES (?,?,?)";
            var stmt = conn.prepareStatement(query);

            stmt.setString(1, beneficiarios.getNm_beneficiario());
            stmt.setString(2, beneficiarios.getEmail());
            stmt.setString(3, beneficiarios.getSenha());

            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void Listar() {

        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "SELECT * FROM T_PIECS_BENEFICIARIOS";
            var stmt = conn.prepareStatement(query);
            var rs = stmt.executeQuery();

            while (rs.next()){
                var rsId = rs.getInt("id");
                var rsBeneficiario = rs.getString("nm_beneficiario");
                var rsEmail = rs.getString("email");
                var rsSenha = rs.getString("senha");
                System.out.println("id" + rsId + "nm_beneficiario" + rsBeneficiario + "email" + rsEmail + "senha" + rsSenha);
            }
            rs.close();
            conn.close();
            stmt.close();
        }
       catch (Exception e){
            e.printStackTrace();
       }
    }

    @Override
    public void Delete(int id) {

        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "DELETE FROM T_PIECS_BENEFICIARIOS WHERE id = ?";
            var stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void UpDate(T_PIECS_BENEFICIARIOS beneficiarios) {

        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "UPDATE T_PIECS_BENEFICIARIOS SET (id, nm_beneficiario, email) VALUE(?,?,?) " +
                    "WHERE id = ?";
            var stmt = conn.prepareStatement(query);

            stmt.setInt("id");
            stmt.setString("nm_beneficiaruio");
            stmt.setString("email");

            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public T_PIECS_BENEFICIARIOS GetById(int id) {

        T_PIECS_BENEFICIARIOS beneficiario = null;

        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "SELECT * FROM T_PIECS_BENEFICIARIOS WHERE id = ?";
            var stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            var rs = stmt.executeQuery();
            if (rs.next()){
                var rsId = rs.getInt("id");
                var rsBeneficiario = rs.getString("nm_beneficiario");

                beneficiario = new T_PIECS_BENEFICIARIOS(rsId, rsBeneficiario);
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beneficiario;
    }
}


