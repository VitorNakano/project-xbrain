package br.com.nakano.xbrain.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO implements Serializable {
    
    private String productName;
    private BigDecimal value;
    private Integer sellerId;

    @Override
    public String toString() {
        return "SaleDTO { "       +
                "value = "       + value      + 
                "productName = "   + productName;
    }

}