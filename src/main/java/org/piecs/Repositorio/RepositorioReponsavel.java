package org.piecs.Repositorio;

import org.piecs.InfraEstrutura.ConexaoBancoDados;
import org.piecs.Modelo.T_PIECS_RESPONSAVEL;


public class RepositorioReponsavel implements RepositorioBase<T_PIECS_RESPONSAVEL>{


    @Override
    public void Adicionar(T_PIECS_RESPONSAVEL responsavel) {

        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "INSERT INTO T_PIECS_RESPONSAVEL (nm_cliente, dt_nascimento, cpf_cnpj, email, senha, qt_armazenada_total) VALUES (?,?,?,?,?,?)";
            var stmt = conn.prepareStatement(query);

            stmt.setString(1, responsavel.getNm_cliente());
            stmt.setInt(2, responsavel.getDt_nascimento());
            stmt.setString(3, responsavel.getCpf_cnpj());
            stmt.setString(4, responsavel.getEmail());
            stmt.setString(5, responsavel.getSenha());
            stmt.setInt(6, responsavel.getQt_armazenada_total());

            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void Listar() {
        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "SELECT * FROM T_PIECS_RESPONSAVEL";
            var stmt = conn.prepareStatement(query);
            var rs = stmt.executeQuery();

            while (rs.next()){
                var rsId = rs.getInt("id");
                var nm_cliente = rs.getString("nm_cliente");
                var dt_nascimento = rs.getInt("dt_nascimento");
                var cpf_cnpj = rs.getString("cpf_cnpj");
                var email = rs.getString("email");
                var senha = rs.getString("senha");
                var qt_armazenada_total = rs.getString("qt_armazenada_total");
                System.out.println("id" + rsId + "| nm_cliente" + nm_cliente + "| cpf_cnpj" + cpf_cnpj);
            }
            rs.close();
            conn.close();
            stmt.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "DELETE FROM T_PIECS_RESPONSAVEL WHERE id = ?";
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

//    @Override
//    public void UpDate() {
//
//    }

    @Override
    public T_PIECS_RESPONSAVEL GetById(int id) {

        T_PIECS_RESPONSAVEL responsavel = null;

        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "SELECT * FROM T_PIECS_RESPONSAVEL WHERE id = ?";
            var stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            var rs = stmt.executeQuery();
            if (rs.next()){
                var rsId = rs.getInt("id");
                var rsCliente = rs.getString("nm_cliente");
                responsavel = new T_PIECS_RESPONSAVEL(rsId, rsCliente);
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return responsavel;
    }
}
