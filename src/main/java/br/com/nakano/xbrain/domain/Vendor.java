package br.com.nakano.xbrain.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vendor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vendorId;
    private String vendorName;
    private Integer sales;
    private Integer salesAverage;

    public Vendor(String vendorName, Integer sales, Integer salesAverage) {
        this.vendorName = vendorName;
        this.sales = sales;
        this.salesAverage = salesAverage;
    }

}
