package miu.edu.datapersistencedto.repository;

import miu.edu.datapersistencedto.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    Optional<Publisher> findPublisherByPublisherName(String publisherName);
}
