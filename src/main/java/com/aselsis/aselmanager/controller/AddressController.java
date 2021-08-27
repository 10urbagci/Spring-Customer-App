package com.aselsis.aselmanager.controller;

import com.aselsis.aselmanager.dto.SaveAddressDto;
import com.aselsis.aselmanager.dto.UpdateAddressDto;
import com.aselsis.aselmanager.model.Address;
import com.aselsis.aselmanager.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping("/all")
    public List<Address> findAll(){
        return addressService.findAll();
    }
    @PostMapping("/save")
    public Address saveAddress(@RequestBody SaveAddressDto saveAddressDto){
        return  addressService.addAddress(saveAddressDto);
    }
    @PutMapping("/{id}")
    public Address replaceAddress(@RequestBody UpdateAddressDto updateAddressDto,@PathVariable Integer id){
        return addressService.updateAddress(id,updateAddressDto);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        addressService.deleteById(id);
    }
    @GetMapping("/{id}")
    Address findById(@PathVariable Integer id){
        return addressService.findById(id);
    }
}
