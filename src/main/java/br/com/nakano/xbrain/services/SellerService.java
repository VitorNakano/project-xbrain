package br.com.nakano.xbrain.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

/*
 * Return Seller Name
 * All Sales
 * Average of Sales between Dates as parameters
 * 
 * Try use GROUP BY and COUNT to resolve the problem
 */

    public List<SellerDTO> listSellerBetweenDates(LocalDate initialDate, LocalDate lastDate, String timeInterval) throws Exception{
        try {
            initialDate = LocalDate.now().minusMonths(6);
            lastDate = LocalDate.now();
            List<SellerDTO> listSellerDto = new ArrayList<>();
            validateDateRange(initialDate, lastDate);
            List<Seller> sellers = sellerRepository.findAll();    
            for(Seller seller : sellers) {
                SellerDTO dto = new SellerDTO();
                dto.setSellerName(sellerName(seller.getSellerId()));
                dto.setAllSales(totalSales(seller.getSellerId()));
                dto.setSalesAverage(averageSalesPerDays(initialDate, lastDate, seller.getSellerId(), timeInterval));
                listSellerDto.add(dto);
            }
            return listSellerDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("The Given date is Invalid!");
        }
    }

    private void validateDateRange(LocalDate initialDate, LocalDate lastDate) throws Exception {
        if(initialDate.isAfter(lastDate)) {
            throw new Exception("The Start Date must be before the End Date");
        }
    }

    private String sellerName(Integer sellerId) {
        return sellerRepository.findById(sellerId).get().getSellerName();
    }

    private Integer totalSales(Integer sellerId) {
        return saleRepository.countOfSale(sellerId);
    }

    private BigDecimal averageSalesPerDays(LocalDate initialDate, LocalDate lastDate,
     Integer sellerId, String timeInterval) throws Exception {
        BigDecimal averageSales;
        Integer countOfSales = saleRepository.findByDateOfSaleBetweenAndSellerId(
            initialDate, lastDate, sellerId);
        long dateInterval = setTimeInterval(initialDate, lastDate, timeInterval, countOfSales);
        averageSales = BigDecimal.valueOf(countOfSales.doubleValue() / dateInterval)
            .setScale(2, RoundingMode.HALF_UP);
        return averageSales;
    }

    private long setTimeInterval(LocalDate initialDate, LocalDate lastDate,
        String timeInterval, Integer countOfSales) throws Exception {
        try {
            long interval = 0;
            if (timeInterval.toUpperCase().equals("D")) {
            interval = ChronoUnit.DAYS.between(initialDate, lastDate);
            } else if (timeInterval.toUpperCase().equals("W")) {
            interval = ChronoUnit.WEEKS.between(initialDate, lastDate);
            } else if (timeInterval.toUpperCase().equals("M")) {
            interval = ChronoUnit.MONTHS.between(initialDate, lastDate);
            } else if (timeInterval.toUpperCase().equals("Y")) {
            interval = ChronoUnit.YEARS.between(initialDate, lastDate);
            }
            return interval;
        } catch (Exception e) {
            throw new Exception("Invalid Period!");
        }
    }
}