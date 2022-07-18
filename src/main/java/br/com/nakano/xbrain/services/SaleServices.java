package br.com.nakano.xbrain.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nakano.xbrain.domain.Sale;
import br.com.nakano.xbrain.domain.Vendor;
import br.com.nakano.xbrain.domain.dto.SaleDTO;
import br.com.nakano.xbrain.repositories.SaleRepository;
import br.com.nakano.xbrain.repositories.VendorRepository;

@Service
public class SaleServices {
    
    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private SaleRepository saleRepository;

    public void makeSale(SaleDTO saleDto) {
        Vendor vendor;
        try {
            vendor = findVendor(saleDto.getVendorId());
            doSale(saleDto, vendor);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    private Vendor findVendor(Integer id) {
        return vendorRepository.getReferenceById(id);
    }

    private void doSale(SaleDTO saleDto, Vendor vendor) {
        Sale sale = new Sale(saleDto.getValue(), LocalDate.now(), vendor.getVendorId(), vendor.getVendorName());
        saleRepository.save(sale);
    }

}