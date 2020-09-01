package com.ray.rayfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.ray.rayfood.domain.entities.Restaurante;

public interface RestaurenteRepositoryQueries {

    List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}