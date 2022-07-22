package br.com.nakano.xbrain.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import br.com.nakano.xbrain.domain.Seller;
import br.com.nakano.xbrain.domain.dto.SellerDTO;
import br.com.nakano.xbrain.repositories.SaleRepository;
import br.com.nakano.xbrain.repositories.SellerRepository;

@Service
public class SellerService {
    
    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private SaleRepository saleRepository;

    public List<Seller> listAllsellers() {
        return sellerRepository.findAll();
    }

    public List<SellerDTO> listSellerBetweenDates(LocalDate initialDate, LocalDate lastDate) throws Exception{
        try {
            validateDateRange(initialDate, lastDate);
            isValidDate(initialDate, lastDate);
            List<SellerDTO> listSellerDto = new ArrayList<>();   
            List<Seller> sellers = sellerRepository.findAll();    
            for(Seller seller : sellers) {
                SellerDTO dto = new SellerDTO();
                dto.setSellerName(sellerName(seller.getSellerId()));
                dto.setAllSales(totalSales(seller.getSellerId()));
                dto.setSalesAverage(averageSalesPerDays(initialDate, lastDate, seller.getSellerId()));
                listSellerDto.add(dto);
            }
            return listSellerDto;
        } catch (Exception e) {
            throw new Exception("The Given date is Invalid!");
        }
    }

    private void validateDateRange(LocalDate initialDate, LocalDate lastDate) throws Exception {
        if(initialDate.isAfter(lastDate)) {
            throw new Exception("The Start Date must be before the End Date");
        }
    }

    private void isValidDate(LocalDate initialDate, LocalDate lastDate) {
        // DateTimeFormat.ISO.DATE
    }

    private String sellerName(Integer sellerId) {
        return sellerRepository.findById(sellerId).get().getSellerName();
    }

    private Integer totalSales(Integer sellerId) {
        return saleRepository.countOfSale(sellerId);
    }

    private BigDecimal averageSalesPerDays(LocalDate initialDate, LocalDate lastDate,
     Integer sellerId) throws Exception {
        BigDecimal averageSales;
        Integer countOfSales = saleRepository.findByDateOfSaleBetweenAndSellerId(
            initialDate, lastDate, sellerId);
        long dateInterval = ChronoUnit.DAYS.between(initialDate, lastDate);
        averageSales = BigDecimal.valueOf(countOfSales.doubleValue() / dateInterval)
            .setScale(2, RoundingMode.HALF_UP);
        return averageSales;
    }
}