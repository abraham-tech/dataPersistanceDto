package miu.edu.datapersistencedto.service;

import miu.edu.datapersistencedto.dto.AddressDto;

import java.util.Optional;

public interface AdressService {
    Optional<AddressDto> addAddress(AddressDto addressDto);
    Optional<AddressDto> updateAddress(Integer addressId, AddressDto addressDto);
    Optional<AddressDto> findAddressById(Integer id);
}
