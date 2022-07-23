package br.com.nakano.xbrain.services;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.nakano.xbrain.domain.dto.SaleDTO;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName(value = "Tests for Services of Sale")
public class TestSaleService {

    @Autowired
    private SaleService service;

    private SaleDTO initDto() {
        SaleDTO saleDto = new SaleDTO();
        saleDto.setProductName("Batatinha");
        saleDto.setSellerId(3);
        saleDto.setValue(BigDecimal.valueOf(3.0));
        return saleDto;
    }

    @Test
    @DisplayName("Don't Make a Sale with value 0")
    public void dontSaleWithValueZero() {
        try {
            SaleDTO testDto = initDto();
            testDto.setValue(BigDecimal.ZERO);
            service.makeSale(testDto);
            Assertions.fail("Errors");
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    @Test
    @DisplayName("Don't Make a Sale with Seller ID 0")
    public void dontSaleWithIdZero() {
        try {
            SaleDTO testDto = initDto();
            testDto.setSellerId(0);
            service.makeSale(testDto);
            Assertions.fail("Errors");
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    @Test
    @DisplayName("Don't Make a Sale with Seller ID null")
    public void dontSaleWithIdNull() {
        try {
            SaleDTO testDto = initDto();
            testDto.setSellerId(null);
            service.makeSale(testDto);
            Assertions.fail("Errors");
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    @Test
    @DisplayName("Don't Make a Sale with Product's Name blank")
    public void dontSaleWithProductNameBlank() {
        try {
            SaleDTO testDto = initDto();
            testDto.setProductName("");
            service.makeSale(testDto);
            Assertions.fail("Errors");
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    @Test
    @DisplayName("Don't Make a Sale with Product's Name null")
    public void dontSaleWithProductNameNull() {
        try {
            SaleDTO testDto = initDto();
            testDto.setProductName(null);
            service.makeSale(testDto);
            Assertions.fail("Errors");
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    @Test
    @DisplayName("Complete a Sale")
    public void completedSale() {
        try {
            SaleDTO testDto = initDto();
            service.makeSale(testDto);
        } catch (Exception e) {
            Assertions.fail("Erros");
        }
    }
}
