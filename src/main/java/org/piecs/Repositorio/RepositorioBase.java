package org.piecs.Repositorio;

import org.piecs.Modelo.EntidadeBase;

import java.util.List;

public interface RepositorioBase <T extends EntidadeBase>{
    void Adicionar(T entidade);
    void Listar ();
    void Delete(String id);
    void UpDate();
    default T GetById(String id){return null;}


}
