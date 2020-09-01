package com.ray.rayfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ray.rayfood.domain.entities.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, RestaurenteRepositoryQueries{
   // List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal); //busque restaurantes com taxa frete entre x e y
    List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinhaId);//busque restaurantes usando "like" e com um id de cozinha x
    
    /*
     * whats is going on? well, olhe o nome do método acima... Enorme!
     * portanto, é possível usar um JPQL com a anotação @Query e passar o JPQL pro método
     * 
     * %:nome% - direcionando para o parâmetro nome (com o mesmo nome)
     * :id -  @Param("id") direcionando para o parâmetro cozinhaId, portanto o @Param é meio que pra ligar os pontos
     */
    @Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
    List<Restaurante> consultaPorNome(String nome, @Param("id") Long cozinhaId);
    
 }
