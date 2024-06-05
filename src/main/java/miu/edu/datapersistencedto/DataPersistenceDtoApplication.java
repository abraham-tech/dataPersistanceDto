package miu.edu.datapersistencedto;

import lombok.RequiredArgsConstructor;
import miu.edu.datapersistencedto.dto.AddressDto;
import miu.edu.datapersistencedto.dto.PublisherDto;
import miu.edu.datapersistencedto.service.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DataPersistenceDtoApplication implements CommandLineRunner {
    private final PublisherService publisherService;

    public static void main(String[] args) {
        SpringApplication.run(DataPersistenceDtoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PublisherDto publisherDto = new PublisherDto("Apress");
        publisherDto.setAddressDto(new AddressDto("1000 N", "Fairfield", "Iowa"));
        System.out.println(publisherService.addPublisher(publisherDto));


        // Update from Apres to Apress
        PublisherDto publisherDto2 = new PublisherDto("Apresss");
        System.out.println(publisherService.updatePublisher("Apress", publisherDto2) + " modified");

    }
}
