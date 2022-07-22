package br.com.nakano.xbrain.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nakano.xbrain.domain.Sale;
import br.com.nakano.xbrain.domain.Seller;
import br.com.nakano.xbrain.domain.dto.SaleDTO;
import br.com.nakano.xbrain.repositories.SaleRepository;
import br.com.nakano.xbrain.repositories.SellerRepository;

@Service
public class SaleService {
    
    @Autowired
    private SellerRepository SellerRepository;

    @Autowired
    private SaleRepository saleRepository;

    public void makeSale(SaleDTO saleDto) throws Exception {
        Seller seller;
        try {
            seller = findSeller(saleDto.getSellerId());
            completeSale(saleDto, seller);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Impossible to complete the Sale.");
        }
    }

    private void completeSale(SaleDTO saleDto, Seller seller) throws Exception {
        try {
            Sale sale = new Sale(saleDto.getProductName(), saleDto.getValue(), LocalDate.now(),
            seller.getSellerId());
            validateSale(sale);
            saleRepository.save(sale);
        } catch (Exception e) {
            throw new Exception("Impossible to Complete the Sale.");
        }
    }

    private void validateSale(Sale sale) throws Exception{
        try {
            checkValueOfSale(sale.getValueOfSale());
        } catch (Exception e) {
            throw new Exception("Invalid Sale! Verify values!");
        }
    }

    private void checkValueOfSale(BigDecimal valueOfSale) throws Exception {
        if(valueOfSale.compareTo(BigDecimal.ZERO) == 0) {
            throw new Exception("Do not make a free sale!");
        }
        if(valueOfSale.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("Impossible to make a negative sale!");
        }
    }

    private Seller findSeller(Integer id) throws Exception {
        if(id.compareTo(0) == 0) {
            throw new Exception("ID 0 don't exist.");
        }
        if (SellerRepository.getReferenceById(id) == null) {
            throw new Exception("ID Seller don't exist.");
        } else {
            return SellerRepository.getReferenceById(id);
        }
    }

}