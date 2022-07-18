package br.com.nakano.xbrain.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "sale")
@Data
public class Sale implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer saleId;
    private BigDecimal valueOfSale;
    private LocalDate dateOfSale;
    private Integer vendorId;
    private String vendorName;

    public Sale (BigDecimal valueOfSale, LocalDate dateOfSale, Integer vendorId, String vendorName) {
        this.valueOfSale = valueOfSale;
        this.dateOfSale = dateOfSale;
        this.vendorId = vendorId;
        this.vendorName = vendorName;
    }

}