package br.com.nakano.xbrain.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.nakano.xbrain.domain.Sale;

@Transactional(readOnly = true)
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    @Query(nativeQuery = true,
        value = "SELECT COUNT(*) FROM sale WHERE date_of_sale BETWEEN ?1 AND ?2 AND seller_id = ?3")
    Integer findByDateOfSaleBetweenAndSellerId(LocalDate initialDate, LocalDate lastDate, Integer sellerId);
    
    @Query(nativeQuery = true,
        value = "SELECT COUNT(*) FROM sale WHERE seller_id = ?1")
    Integer countOfSale(Integer sellerId);
}