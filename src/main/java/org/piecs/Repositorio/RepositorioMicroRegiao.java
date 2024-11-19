package org.piecs.Repositorio;


import org.piecs.InfraEstrutura.ConexaoBancoDados;
import org.piecs.Modelo.T_PIECS_ENDERECO;
import org.piecs.Modelo.T_PIECS_MICRO_REGIAO;

import java.util.List;


public class RepositorioMicroRegiao implements RepositorioBase<T_PIECS_MICRO_REGIAO>{


    @Override
    public void Adicionar(T_PIECS_MICRO_REGIAO microRegiao) {

        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "INSERT INTO T_PIECS_MICRO_REGIAO(qt_placa, capacidade_placa, qt_bateria, capacidade_bateria) VALUES (?,?,?,?)"
            var stmt = conn.prepareStatement(query);

            stmt.setInt(1, microRegiao.getQt_placa());
            stmt.setInt(2, microRegiao.getCapacidade_placa());
            stmt.setInt(3, microRegiao.getQt_bateria());
            stmt.setInt(4, microRegiao.getCapacidade_bateria());
            stmt.setInt(5, microRegiao.getQt_armazenada_energia());
            stmt.close();
            conn.close();

        }  catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<T_PIECS_ENDERECO> Listar() {
        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "SELECT * FROM T_PIECS_ENDERECO";
            var stmt = conn.prepareStatement(query);
            var rs = stmt.executeQuery();

            while (rs.next()){
                var rsCEP = rs.getString("cep");
                var nomeResponsavel = rs.getString("Nome do Responsável");

                System.out.println("CEP" + rsCEP + "| Nome responsavel: " + nomeResponsavel);

            }
            rs.close();
            stmt.close();
            conn.close();

        }  catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void Delete(int id) {
        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "DELETE FROM T_PIECS_MICRO_REGIAO WHERE id = ?";
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
    public T_PIECS_MICRO_REGIAO GetById(int id) {
        T_PIECS_MICRO_REGIAO microRegiao = new T_PIECS_MICRO_REGIAO();

        try{
            var conn = ConexaoBancoDados.getConnection();
            var query = "SELECT * FROM T_PIECS_MICRO_REGIAO WHERE id = ?";
            var stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            var rs = stmt.executeQuery();

            if(rs.next()){
                var nomeResponsavel = rs.getString("nomeResponsavel");
                microRegiao = new T_PIECS_MICRO_REGIAO();
            }
            rs.close();
            conn.close();
            stmt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return microRegiao;
    }
}



