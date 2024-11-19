package org.piecs.Repositorio;

import org.piecs.Modelo.T_PIECS_MICRO_REGIAO;

import java.util.List;

public class RepositorioMicroRegiao implements RepositorioBase<T_PIECS_MICRO_REGIAO>{
    @Override
    public void Adicionar(T_PIECS_MICRO_REGIAO entidade) {

    }

    @Override
    public void Listar() {

    }

    @Override
    public void Delete(String id) {

    }

    @Override
    public T_PIECS_MICRO_REGIAO GetById(String id) {
        return RepositorioBase.super.GetById(id);
    }

    @Override
    public List<T_PIECS_MICRO_REGIAO> GetAll() {
        return RepositorioBase.super.GetAll();
    }
}
