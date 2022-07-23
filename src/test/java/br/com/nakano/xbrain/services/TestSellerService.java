package br.com.nakano.xbrain.services;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.nakano.xbrain.domain.dto.SellerDTO;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName(value = "Tests for Services of Seller")
public class TestSellerService {

    @Autowired
    private SellerService service;

    @Test
    @DisplayName("Should return an error with an invalid Date sequence")
    public void shouldReturnAnErrorWithInvalidDateSequence() {
        try {
            LocalDate initialDate = LocalDate.now();
            LocalDate finalDate = LocalDate.now().minusMonths(6);
            List<SellerDTO> dtos = service.listSellerBetweenDates(initialDate, finalDate);
            Assertions.assertEquals(0, dtos.size());
            Assertions.fail("Erros");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}