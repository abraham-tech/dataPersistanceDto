package miu.edu.datapersistencedto.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.datapersistencedto.dto.AddressDto;
import miu.edu.datapersistencedto.dto.PublisherDto;
import miu.edu.datapersistencedto.model.Address;
import miu.edu.datapersistencedto.model.Publisher;
import miu.edu.datapersistencedto.repository.PublisherRepository;
import miu.edu.datapersistencedto.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    @Override
    public Optional<PublisherDto> addPublisher(PublisherDto publisherDto) {
        // publisherDto contains publisher name and addressDto
        Publisher publisher = new Publisher();
        publisher.setPublisherName(publisherDto.getPublisherName());
        Address address = new Address(
                publisherDto.getAddressDto().getStreet(),
                publisherDto.getAddressDto().getCity(),
                publisherDto.getAddressDto().getState()
                );
        publisher.setPublisherAddress(address);
        Publisher savedPublisher = publisherRepository.save(publisher);
        PublisherDto responsePublisherDto = new PublisherDto();
        responsePublisherDto.setPublisherName(savedPublisher.getPublisherName());
        responsePublisherDto.setAddressDto(
                new AddressDto(
                        savedPublisher.getPublisherAddress().getStreet(),
                        savedPublisher.getPublisherAddress().getCity(),
                        savedPublisher.getPublisherAddress().getState()
                )
        );
        return Optional.of(responsePublisherDto);
    }

    @Override
    public Optional<PublisherDto> updatePublisher(String publisherName, PublisherDto publisherDto) {
        // Check whether the publisherName is existing or not

        Optional<Publisher> foundPublisher = publisherRepository.findPublisherByPublisherName(publisherName);
        if (foundPublisher.isPresent()) {
            Publisher publisher = foundPublisher.get();
            publisher.setPublisherName(publisherDto.getPublisherName());
            Publisher modifiedPublisher = publisherRepository.save(publisher);
            PublisherDto responsePublisherDto = new PublisherDto(modifiedPublisher.getPublisherName());
            responsePublisherDto.setAddressDto(
                    new AddressDto(
                    modifiedPublisher.getPublisherAddress().getStreet(),
                    modifiedPublisher.getPublisherAddress().getCity(),
                    modifiedPublisher.getPublisherAddress().getState()
                    )
            );
            return Optional.of(responsePublisherDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<PublisherDto> findPublisherByName(String publisherName) {
        return Optional.empty();
    }
}
