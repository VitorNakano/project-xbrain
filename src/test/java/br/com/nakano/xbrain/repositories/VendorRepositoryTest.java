package br.com.nakano.xbrain.repositories;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.nakano.xbrain.domain.Vendor;

@SpringBootTest
@DisplayName(value = "Tests from Vendor Repository")
@ActiveProfiles("test")
public class VendorRepositoryTest {
    
    @Autowired
    private VendorRepository vendorRepository;

    private Vendor vendorTest;

    private void createVendor() {
        vendorTest = new Vendor();
        vendorTest.setVendorName("Nakano");
        vendorTest.setSales(30);
        vendorTest.setSalesAverage(6);
    }

}
