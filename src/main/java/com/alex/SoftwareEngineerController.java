package com.alex;

import jakarta.validation.Valid;
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

    //get all through dto
    @GetMapping
    public List<SoftwareEngineerDTO> getAllSoftwareEngineersDTO() {
        return softwareEngineerService.getAllSoftwareEngineersDTO();
    }


    @PostMapping
    public void addNewSoftwareEngineer(@Valid @RequestBody SoftwareEngineerDTO softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    /* get all
    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id) {

        return softwareEngineerService.getSoftwareEngineerById(id);
    }
*/
    //update
    @PutMapping("{id}")
    public SoftwareEngineerDTO putEngineerById(@PathVariable Integer id,@Valid @RequestBody SoftwareEngineerDTO dto) {

        return softwareEngineerService.updateEngineer(id, dto);
    }
    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSoftwareEngineerById(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineerById(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }

    //get by techstack
    @GetMapping("/search")
    public List<SoftwareEngineerDTO> getEngineersByTechStack(@RequestParam(value = "techStack") String techStack) {
        return  softwareEngineerService.getEngineersByTechStack(techStack);
    }

}
