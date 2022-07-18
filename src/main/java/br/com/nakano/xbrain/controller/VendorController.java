package br.com.nakano.xbrain.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.nakano.xbrain.domain.dto.VendorDTO;
import br.com.nakano.xbrain.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Vendor")
public class VendorController {
    
    @Autowired
    private VendorService vendorService;

    @RequestMapping(value = "/listAllVendors", method = RequestMethod.GET)
    @ApiOperation(value = "List Vendors", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VendorDTO> listAllVendors() throws Exception {
        try {
            VendorDTO vendorDto  = new VendorDTO("Nakano");
            return ResponseEntity.ok().body(vendorDto);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            throw new Exception();
        }
    }

}
