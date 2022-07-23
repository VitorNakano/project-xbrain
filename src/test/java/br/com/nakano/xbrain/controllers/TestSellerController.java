package br.com.nakano.xbrain.controllers;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import br.com.nakano.xbrain.controller.SellerController;
import br.com.nakano.xbrain.domain.dto.SellerDTO;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName(value = "Tests for Seller Controller")
public class TestSellerController {
    
    @Autowired
    private SellerController controller;
    
    @Test
    @DisplayName("Should List the sellers with correct parameters")
    public void listTheSellers() {
        try {
            ResponseEntity<List<SellerDTO>> response = controller.listAllSellers(LocalDate.now().minusMonths(6), LocalDate.now());
            Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Error");
        }
    }

    @Test
    @DisplayName("Don't List the sellers with incorrect parameters")
    public void dontListTheSellers() {
        try {
            ResponseEntity<List<SellerDTO>> response = controller.listAllSellers(LocalDate.now(), LocalDate.now().minusMonths(6));
            Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
            Assertions.fail("Error");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
