package br.com.nakano.xbrain.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaleDTO implements Serializable {
    
    private String productName;
    private BigDecimal value;
    private Integer sellerId;
    private String sellerName;

}