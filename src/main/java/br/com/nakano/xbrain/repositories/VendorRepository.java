package br.com.nakano.xbrain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.nakano.xbrain.domain.Vendor;

@Transactional
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}