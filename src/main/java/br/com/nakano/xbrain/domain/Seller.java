package br.com.nakano.xbrain.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seller")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sellerId;
    @Column(nullable = false)
    @NotNull
    private String sellerName;

    public Seller(String sellerName) {
        this.sellerName = sellerName;
    }

}
