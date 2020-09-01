package com.ray.rayfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.ray.rayfood.domain.entities.Restaurante;
/*
 * pra quÊ essa interface? só pra caso mudar o nome lá na implemetnação nao dar erro, ok?, basicamente isso kk
 */
public interface RestaurenteRepositoryQueries {

    List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}