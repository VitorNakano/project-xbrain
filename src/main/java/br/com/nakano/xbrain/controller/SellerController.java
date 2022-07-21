package br.com.nakano.xbrain.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.nakano.xbrain.domain.dto.SellerDTO;
import br.com.nakano.xbrain.repositories.SellerRepository;
import br.com.nakano.xbrain.services.SellerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Seller")
public class SellerController {
    
    @Autowired
    private SellerService sellerService;

    @Autowired
    SellerRepository sellerRepository;

    @RequestMapping(value = "/listAllSellers", method = RequestMethod.GET)
    @ApiOperation(value = "List Sellers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SellerDTO>> listAllSellers() throws Exception {
        // LocalDate initialDate, LocalDate lastDate
        try {
            List<SellerDTO> sellerDto  = sellerService.listSellerBetweenDates(LocalDate.now().minusMonths(6), LocalDate.now(), "D");
            return ResponseEntity.ok().body(sellerDto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}
