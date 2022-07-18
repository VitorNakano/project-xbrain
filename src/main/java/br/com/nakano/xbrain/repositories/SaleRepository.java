package br.com.nakano.xbrain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.nakano.xbrain.domain.Sale;

@Transactional(readOnly = true)
public interface SaleRepository extends JpaRepository<Sale, Integer> {

}