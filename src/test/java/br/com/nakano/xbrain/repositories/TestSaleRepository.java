package br.com.nakano.xbrain.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName(value = "Tests for Sales Repository")
public class TestSaleRepository {
    
    @Autowired
    private SaleRepository repository;

    @Test
    @DisplayName("Should return a Count greater than 1 with a valid Seller ID")
    public void shouldReturnCountGreaterThanOneWithValidSellerId() {
        try {
            Integer count = repository.countOfSale(1);
            Assertions.assertTrue(count.compareTo(0) > 0);
        } catch (Exception e) {
            Assertions.fail("Errors");
        }
    }

    @Test
    @DisplayName("Should return a Count 0 with a valid Seller ID")
    public void shouldReturnCountZeroWithValidSellerId() {
        try {
            Integer count = repository.countOfSale(0);
            Assertions.assertTrue(count.compareTo(0) == 0);
        } catch (Exception e) {
            Assertions.fail("Errors");
        }
    }
}