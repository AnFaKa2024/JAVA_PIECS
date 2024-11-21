package org.piecs.Repositorio;

import org.piecs.Modelo.EntidadeBase;
import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;
import org.piecs.Modelo.T_PIECS_ENDERECO;

import java.util.List;

public interface RepositorioBase <T extends EntidadeBase>{
    void Adicionar(T entidade);
    List<T_PIECS_ENDERECO> Listar();
    void Delete(String id);
    void UpDate();

    void UpDate(T_PIECS_BENEFICIARIOS beneficiario);

    default T GetById(String id){return null;}


}
