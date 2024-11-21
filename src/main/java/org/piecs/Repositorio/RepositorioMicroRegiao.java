package org.piecs.Repositorio;

import org.piecs.InfraEstrutura.ConexaoBancoDados;
import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;
import org.piecs.Modelo.T_PIECS_ENDERECO;
import org.piecs.Modelo.T_PIECS_MICRO_REGIAO;
import org.piecs.Modelo.T_PIECS_RESPONSAVEL;

import java.util.List;

public class RepositorioMicroRegiao implements RepositorioBase<T_PIECS_MICRO_REGIAO> {

    @Override
    public void Adicionar(T_PIECS_MICRO_REGIAO microRegiao) {
        String query = "INSERT INTO T_PIECS_MICRO_REGIAO(qt_placa, capacidade_placa, qt_bateria," +
                " capacidade_bateria, qt_armazenada_energia, responsavel_id, endereco_id) VALUES (?,?,?,?,?,?,?)";

        try (var conn = ConexaoBancoDados.getConnection();
             var stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, microRegiao.getQt_placa());
            stmt.setInt(2, microRegiao.getCapacidade_placa());
            stmt.setInt(3, microRegiao.getQt_bateria());
            stmt.setInt(4, microRegiao.getCapacidade_bateria());
            stmt.setInt(5, microRegiao.getQt_armazenada_energia());
            stmt.setString(6, microRegiao.getResponsavel().getId());
            stmt.setString(7, microRegiao.getEndereco().getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T_PIECS_ENDERECO> Listar() {
        String query = "SELECT * FROM T_PIECS_MICRO_REGIAO";

        try (var conn = ConexaoBancoDados.getConnection();
             var stmt = conn.prepareStatement(query);
             var rs = stmt.executeQuery()) {

            while (rs.next()) {
                String cep = rs.getString("cep");
                String nomeResponsavel = rs.getString("nome_responsavel");
                String endereco = rs.getString("endereco");
                System.out.println("CEP: " + cep + " | Nome responsável: " + nomeResponsavel + " | Endereço: " + endereco);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void Delete(String id) {
        String query = "DELETE FROM T_PIECS_MICRO_REGIAO WHERE id = ?";

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
    public T_PIECS_MICRO_REGIAO GetById(String id) {
        T_PIECS_MICRO_REGIAO microRegiao = null;

        String query = "SELECT * FROM T_PIECS_MICRO_REGIAO WHERE id = ?";

        try (var conn = ConexaoBancoDados.getConnection();
             var stmt = conn.prepareStatement(query)) {

            stmt.setString(1, id);
            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    var rsNome = "";
                    var rsIdMicroRegiao = 0;
                    microRegiao = new T_PIECS_MICRO_REGIAO(rsIdMicroRegiao, rsNome);
                    microRegiao.setQt_placa(rs.getInt("qt_placa"));
                    microRegiao.setCapacidade_placa(rs.getInt("capacidade_placa"));
                    microRegiao.setQt_bateria(rs.getInt("qt_bateria"));
                    microRegiao.setCapacidade_bateria(rs.getInt("capacidade_bateria"));
                    microRegiao.setQt_armazenada_energia(rs.getInt("qt_armazenada_energia"));

                    String responsavelId = rs.getString("responsavel_id");
                    String enderecoId = rs.getString("endereco_id");

                    if (rs.next()) {
                        rsIdMicroRegiao = rs.getInt("id_micro_regiao");
                        rsNome = rs.getString("nm_cliente");
                        var rsCep = rs.getString("cep");
                        microRegiao = new T_PIECS_MICRO_REGIAO(rsIdMicroRegiao, rsNome);

                        T_PIECS_RESPONSAVEL responsavel = new T_PIECS_RESPONSAVEL(rsIdMicroRegiao, rsNome);
                        responsavel.setId(responsavelId);

                        T_PIECS_ENDERECO endereco = new T_PIECS_ENDERECO(rsIdMicroRegiao, rsCep);
                        endereco.setId(enderecoId);

                        microRegiao.setResponsavel(responsavel);
                        microRegiao.setEndereco(endereco);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return microRegiao;
    }
}
