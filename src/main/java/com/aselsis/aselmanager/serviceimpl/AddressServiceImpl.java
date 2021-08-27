package com.aselsis.aselmanager.serviceimpl;

import com.aselsis.aselmanager.dto.SaveAddressDto;
import com.aselsis.aselmanager.dto.UpdateAddressDto;
import com.aselsis.aselmanager.model.Address;
import com.aselsis.aselmanager.repository.AddressRepository;
import com.aselsis.aselmanager.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    @Override
    public Address addAddress(SaveAddressDto saveAddressDto){
        Address address = new Address();

        address.setDistrict(saveAddressDto.getDistrict());

        address.setNeighborhood(saveAddressDto.getNeighborhood());

        address.setProvince(saveAddressDto.getProvince());

        address.setHouseNo(saveAddressDto.getHouseNo());

        address = addressRepository.save(address);

        return address;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(Integer addressId, UpdateAddressDto updateAddressDto) {
        Optional<Address> addressOptional = addressRepository.findById(addressId);

        Address address = addressOptional.get();

        address.setHouseNo(updateAddressDto.getHouseNo());

        address.setDistrict(updateAddressDto.getDistrict());

        address.setProvince(updateAddressDto.getProvince());

        address.setNeighborhood(updateAddressDto.getNeighborhood());

        address = addressRepository.save(address);

        return address;
    }

    @Override
    public void deleteById(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address findById(Integer id) {
        Optional<Address> opAddress = addressRepository.findById(id);

        return opAddress.get();
    }
}
