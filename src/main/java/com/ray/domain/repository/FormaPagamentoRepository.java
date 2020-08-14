package com.ray.domain.repository;

import java.util.List;

import com.ray.domain.entities.FormaPagamento;

public interface FormaPagamentoRepository {
    
    List<FormaPagamento> todas();
    FormaPagamento porId(Long id);
    FormaPagamento adicionar(FormaPagamento umaFormaPagamento);
    void remover(FormaPagamento umaFormaPagamento);

}
