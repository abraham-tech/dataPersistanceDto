package miu.edu.datapersistencedto.service;

import miu.edu.datapersistencedto.dto.PublisherDto;
import miu.edu.datapersistencedto.model.Publisher;

import java.util.Optional;

public interface PublisherService {
    //    Optional<Publisher> addPublisher(Publisher publisher);
    Optional<PublisherDto> addPublisher(PublisherDto publisherDto);

    Optional<PublisherDto> updatePublisher(String publisherName, PublisherDto publisherDto);

    Optional<PublisherDto> findPublisherByName(String publisherName);
}
