package br.com.nakano.xbrain.repositories;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.nakano.xbrain.domain.Seller;

@SpringBootTest
@DisplayName(value = "Tests from Seller Repository")
@ActiveProfiles("test")
public class TestSellerRepository {

    @Autowired
    private SellerRepository sellerRepository;

    private Seller sellerTest;

    private void createSeller() {
        sellerTest = new Seller();
        sellerTest.setSellerName("Nakano");
    }

    @Test
    @DisplayName(value = "Don't add a Null Seller")
    public void doNotAddWithNullSeller() {
        try {
            sellerRepository.save(new Seller());
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "Don't Add a Seller with a blank Name")
    public void doNotAddSellerBlankName() {
        try {
            createSeller();
            sellerTest.setSellerName("");
            Assertions.assertNotEquals("", sellerTest.getSellerName(), "Name is Blank");
            sellerRepository.save(sellerTest);
            System.out.println(sellerTest.getSellerName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
