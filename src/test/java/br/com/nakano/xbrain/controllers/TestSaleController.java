package br.com.nakano.xbrain.controllers;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import br.com.nakano.xbrain.controller.SaleController;
import br.com.nakano.xbrain.domain.dto.SaleDTO;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName(value = "Tests for Sale Controller")
public class TestSaleController {
 
    @Autowired
    private SaleController controller;

    private SaleDTO initDto() {
        SaleDTO saleDto = new SaleDTO();
        saleDto.setProductName("Batatinha");
        saleDto.setSellerId(3);
        saleDto.setValue(BigDecimal.valueOf(3.0));
        return saleDto;
    }

    @Test
    @DisplayName("Make a Sale")
    public void makeSale() {
        try {
            SaleDTO dto = initDto();
            ResponseEntity<String> response = controller.sale(dto);
            Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Error");
        }
    }

    @Test
    @DisplayName("Don't make a sale with blank product name")
    public void dontMakeSaleWithBlankProductName() {
        try {
            SaleDTO dto = initDto();
            dto.setProductName("");
            ResponseEntity<String> response = controller.sale(dto);
            Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
            Assertions.fail("Error");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Don't make a sale with Seller ID 0")
    public void dontMakeSaleWithSellerIdZero() {
        try {
            SaleDTO dto = initDto();
            dto.setSellerId(0);
            ResponseEntity<String> response = controller.sale(dto);
            Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
            Assertions.fail("Error");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Don't make a sale with Valeu of Sale 0")
    public void dontMakeSaleWithValueOfSaleZero() {
        try {
            SaleDTO dto = initDto();
            dto.setValue(BigDecimal.ZERO);
            ResponseEntity<String> response = controller.sale(dto);
            Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
            Assertions.fail("Error");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}