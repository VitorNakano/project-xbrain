package br.com.nakano.xbrain.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaleDTO implements Serializable {
    
    private BigDecimal value;
    private Integer vendorId;
    private String vendorName;

}