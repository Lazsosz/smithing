package hu.peterlazsan.smith.controller;

import hu.peterlazsan.smith.model.dao.Smith;
import hu.peterlazsan.smith.model.dao.SmithWork;
import hu.peterlazsan.smith.model.dto.SmithingJob;
import hu.peterlazsan.smith.model.other.Metal;
import hu.peterlazsan.smith.service.SmithingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/smith")
@RestController
public class SmithingController {


    @Autowired
    private SmithingService smithingService;


    @GetMapping("/all")
    @Operation(summary = "Get Smith by id",
            description = "Get Smith by id",
            tags = {"Smith"},
            operationId = "getSmiths")
    private List<Smith> getAllSmiths() {
        return smithingService.getAllSmiths();
    }

    @GetMapping("/all/work")
    @Operation(summary = "Get SmithWork by id",
            description = "Get SmithWork by id",
            tags = {"SmithWork"},
            operationId = "getSmithsWork")
    private List<SmithWork> getAllSmithsWork() {
        return smithingService.getAllSmithsWork();
    }

    @PostMapping("/add/smith")
    @Operation(summary = "Add Smith",
            description = "Add Smith",
            tags = {"Smith"},
            operationId = "addSmith")
    private Smith addSmith(Smith smith) {
        return smithingService.addSmith(smith);
    }

    @PostMapping("/add/work")
    @Operation(summary = "Add SmithWork",
            description = "Add SmithWork",
            tags = {"SmithWork"},
            operationId = "addSmithWork")
    private SmithingJob addSmithWork(SmithWork smithWork) {
        return smithingService.addSmithWork(smithWork);
    }

    @Operation(summary = "Get SmithingJobs",
            description = "Get SmithingJobs",
            tags = {"SmithingJob"},
            operationId = "getSmithingJob")
    @GetMapping("/all/smithingjob")
    private List<SmithingJob> getAllSmithingJob() {
        return smithingService.getAllSmithingJob();
    }
}
