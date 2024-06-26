package miu.edu.datapersistencedto.repository;

import miu.edu.datapersistencedto.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findAddressByAddressId(Integer addressId);
}
