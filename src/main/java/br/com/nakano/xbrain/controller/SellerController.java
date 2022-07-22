package br.com.nakano.xbrain.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.nakano.xbrain.domain.dto.SellerDTO;
import br.com.nakano.xbrain.services.SellerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Seller")
public class SellerController {
    
    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/listAllSellers", method = RequestMethod.GET)
    @ApiOperation(value = "List Sellers", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success!"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Exist some Errors!")
    })
    public ResponseEntity<List<SellerDTO>> listAllSellers(
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(name = "initialDate", value = "Initial Date", example = "yyyy-MM-dd") LocalDate initialDate, 
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(name = "lastDate", value = "Last Date",example = "yyyy-MM-dd") LocalDate lastDate)
         throws Exception {
        try {
            List<SellerDTO> sellerDto  = sellerService.listSellerBetweenDates(initialDate, lastDate);
            return ResponseEntity.ok().body(sellerDto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}