package br.com.nakano.xbrain.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    @DisplayName(value = "Don't list with wrong Date Format")
    public void dontListWithWrongDateFormat() {
        try {
            DateTimeFormatter wrongFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String date = "01-01-2022";
            String anotherDate = "01-07-2022";
            LocalDate initialDate = LocalDate.parse(date, wrongFormat);
            LocalDate lastDate = LocalDate.parse(anotherDate, wrongFormat);
            List<SellerDTO> dtos = service.listSellerBetweenDates(initialDate, lastDate);
            System.out.println(dtos);
            Assertions.assertEquals(0, dtos.size());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("e.printStackTrace()");
        }
    }
}