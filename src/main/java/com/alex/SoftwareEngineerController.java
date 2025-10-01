package com.alex;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/software_engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @PostMapping
    public void addNewSoftwareEngineer(@Valid @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id) {

        return softwareEngineerService.getSoftwareEngineerById(id);
    }
    @PutMapping("{id}")
    public SoftwareEngineer putEngineerById(@PathVariable Integer id,@Valid @RequestBody SoftwareEngineer softwareEngineer) {

        return softwareEngineerService.putSoftwareEngineerById(id, softwareEngineer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSoftwareEngineerById(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineerById(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }

}
