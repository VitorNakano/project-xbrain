package br.com.nakano.xbrain.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sale")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saleId;
    @NotNull
    private String productName;
    @NotNull
    private BigDecimal valueOfSale;
    @NotNull
    private LocalDate dateOfSale;
    @JoinColumn(name = "seller_id")
    private Integer sellerId;

    public Sale (String productName, BigDecimal valueOfSale, LocalDate dateOfSale, Integer sellerId) {
        this.productName = productName;
        this.valueOfSale = valueOfSale;
        this.dateOfSale = dateOfSale;
        this.sellerId = sellerId;
    }

}