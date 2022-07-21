package br.com.nakano.xbrain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.nakano.xbrain.domain.Seller;

@Transactional
public interface SellerRepository extends JpaRepository<Seller, Integer> {

}