package com.ray.rayfood.domain.repository;

import java.util.List;

import com.ray.rayfood.domain.entities.FormaPagamento;

public interface FormaPagamentoRepository {
    
    List<FormaPagamento> todas();
    FormaPagamento porId(Long id);
    FormaPagamento adicionar(FormaPagamento umaFormaPagamento);
    void remover(FormaPagamento umaFormaPagamento);

}
