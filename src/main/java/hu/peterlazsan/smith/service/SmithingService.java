package hu.peterlazsan.smith.service;


import hu.peterlazsan.smith.model.dao.Smith;
import hu.peterlazsan.smith.model.dao.SmithWork;
import hu.peterlazsan.smith.model.dto.SmithingJob;
import hu.peterlazsan.smith.model.other.Item;
import hu.peterlazsan.smith.model.other.Metal;
import hu.peterlazsan.smith.model.repos.SmithRepo;
import hu.peterlazsan.smith.model.repos.SmithWorkRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SmithingService {

    @Value("${metalwork.url:http://localhost:7180/}")
    private String metalworkUrl;

    private final RestTemplate restTemplate;
    private SmithRepo smithRepo;
    private SmithWorkRepo smithWorkRepo;


    public SmithingService(RestTemplate restTemplate, SmithRepo smithRepo, SmithWorkRepo smithWorkRepo) {
        this.restTemplate = restTemplate;
        this.smithRepo = smithRepo;
        this.smithWorkRepo = smithWorkRepo;
    }

    @PostConstruct
    public void init() {
        if (metalworkUrl == null || metalworkUrl.isEmpty()) {
            throw new RuntimeException("Restaurant url is not set!");
        }


        log.info("Metalwork url: {}", metalworkUrl);

        if(getAllMetals().isEmpty()) {
            throw new RuntimeException("Metalwork is not available!");
        }
    }

    public List<Metal> getAllMetals() {
        return Arrays.asList(restTemplate.getForObject(metalworkUrl + "metal", Metal[].class));
    }

    public List<Smith> getAllSmiths() {
        return smithRepo.findAll();
    }
    public List<SmithWork> getAllSmithsWork() {
        return smithWorkRepo.findAll();
    }

    public Smith addSmith(Smith smith) {
        return smithRepo.save(smith);
    }

    public Item getItemFromMetalWork(Long id) {
        return restTemplate.getForObject(metalworkUrl + "item/" + id, Item.class);
    }

    public SmithingJob addSmithWork(SmithWork smithWork) {
        return SmithingJob.builder()
                .smithWork(getItemFromMetalWork(smithWork.getWork()))
                .smith(smithRepo.findById(smithWork.getSmithId()).orElseThrow(() -> new RuntimeException("Smith not found!")))
                .build();
    }

    public List<SmithingJob> getAllSmithingJob() {
        return smithWorkRepo.findAll().stream()
                .map(this::addSmithWork)
                .collect(Collectors.toList());
    }

}
