package org.piecs.Repositorio;

import org.piecs.InfraEstrutura.ConexaoBancoDados;
import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;
import org.piecs.Modelo.T_PIECS_ENDERECO;

import java.sql.SQLException;
import java.util.List;

public class RepositorioEndereco implements RepositorioBase<T_PIECS_ENDERECO>{


    @Override
    public void Adicionar(T_PIECS_ENDERECO endereco) {

        try {
            var conn = ConexaoBancoDados.getConnection();
            var query = "INSERT INTO T_PIECS_ENDERECO (cep, rua, bairro, cidade, estado, numero) VALUES (?,?,?,?,?,?)";
            var stmt = conn.prepareStatement(query);

            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setInt(6, endereco.getNumero());

            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void Listar() {
        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "SELECT * FROM T_PIECS_ENDERECO";
            var stmt = conn.prepareStatement(query);
            var rs = stmt.executeQuery();

            while (rs.next()){
                var rsId = rs.getInt("id");
                var rsRua = rs.getString("rua");
                var rsBairro = rs.getString("bairro");
                var rsCidade = rs.getString("cidade");
                var rsEstado = rs.getString("estado");
                var rsNumero = rs.getInt("numero");
                System.out.println("id" + rsId + "rua" + rsRua + "bairro" + rsBairro + "cidade" + rsCidade + "estado" + rsEstado + "numero");
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
            var query = "DELETE FROM T_PIECS_ENDERECO WHERE id = ?";
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
    public T_PIECS_ENDERECO GetById(int id) {

        T_PIECS_ENDERECO endereco = null;

        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "SELECT * FROM T_PIECS_ENDERECO WHERE id = ?";
            var stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            var rs = stmt.executeQuery();
            if (rs.next()){
                var rsId = rs.getInt("id");
                var rsCep = rs.getString("cep");
                endereco = new T_PIECS_ENDERECO(rsId, rsCep);
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return endereco;
    }
}