package org.piecs.Repositorio;

import org.piecs.Modelo.T_PIECS_RESPONSAVEL;

import java.util.List;

public class RepositorioReponsavel implements RepositorioBase<T_PIECS_RESPONSAVEL>{
    @Override
    public void Adicionar(T_PIECS_RESPONSAVEL entidade) {

    }

    @Override
    public void Listar() {

    }

    @Override
    public void Delete(String id) {

    }

    @Override
    public T_PIECS_RESPONSAVEL GetById(String id) {
        return RepositorioBase.super.GetById(id);
    }

    @Override
    public List<T_PIECS_RESPONSAVEL> GetAll() {
        return RepositorioBase.super.GetAll();
    }
}
