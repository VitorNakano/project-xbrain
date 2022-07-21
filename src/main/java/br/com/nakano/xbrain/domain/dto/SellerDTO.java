package br.com.nakano.xbrain.domain.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO {
    
    private String sellerName;
    private Integer allSales;
    private BigDecimal salesAverage;
    
    @Override
    public String toString() {
        return "SellerDTO { "       +
                "sellerName = "     + sellerName    +
                "allSales = "       + allSales      + 
                "salesAverage = "   + salesAverage;
    }
}
