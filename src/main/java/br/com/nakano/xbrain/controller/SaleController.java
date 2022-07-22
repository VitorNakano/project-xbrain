package br.com.nakano.xbrain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.nakano.xbrain.domain.dto.SaleDTO;
import br.com.nakano.xbrain.services.SaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Sale")
public class SaleController {
    
    @Autowired
    private SaleService saleServices;

    @RequestMapping(value = "/makeSale", method = RequestMethod.POST)
    @ApiOperation(value = "Make a Sale", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success!"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Exist some Errors!")
    })
    public ResponseEntity<String> sale(@RequestBody SaleDTO dto) throws Exception {
        try {
            saleServices.makeSale(dto);
            return ResponseEntity.ok().body("Sale Complete!");
        } catch (Exception e) {
            throw new Exception("Error");
        }
    }
}
