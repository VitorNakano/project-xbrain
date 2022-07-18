package br.com.nakano.xbrain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nakano.xbrain.domain.Vendor;
import br.com.nakano.xbrain.repositories.VendorRepository;

@Service
public class VendorService {
    
    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> listAllVendors() {
        return vendorRepository.findAll();
    }

}