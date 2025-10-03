package com.alex;


import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final HandlerExceptionResolver handlerExceptionResolver;
    private SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository, HandlerExceptionResolver handlerExceptionResolver) {
        this.softwareEngineerRepository = softwareEngineerRepository;
        this.handlerExceptionResolver = handlerExceptionResolver;
    }

    /* Get all software engineers
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }*/

    /*Get all software engineers but through the dto */
    public List<SoftwareEngineerDTO> getAllSoftwareEngineersDTO() {
        return softwareEngineerRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    /*Insert one software engineer*/
    public void insertSoftwareEngineer(@Valid SoftwareEngineerDTO dto) {
        SoftwareEngineer engineer = new SoftwareEngineer();
        engineer.setName(dto.getName());
        engineer.setTechStack(dto.getTechStack());

        softwareEngineerRepository.save(engineer);
    }

    /*Get one software engineer by id*/
    public SoftwareEngineerDTO getSoftwareEngineerById(Integer id) {
        SoftwareEngineer engineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Engineer " + id + " not found"));

        return new SoftwareEngineerDTO(
                engineer.getId(),
                engineer.getName(),
                engineer.getTechStack()
        );
    }


    /*Update a software engineer */
    public SoftwareEngineerDTO updateEngineer(Integer id, @Valid SoftwareEngineerDTO dto) {

        SoftwareEngineer engineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Engineer" + id + " not found"));

        engineer.setName(dto.getName());
        engineer.setTechStack(dto.getTechStack());

        softwareEngineerRepository.save(engineer);

        return mapToDTO(engineer);


    }

    /*Delete a software engineer */
    public void deleteSoftwareEngineerById(Integer id) {
        SoftwareEngineer engineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Engineer" + id + " not found"));

        softwareEngineerRepository.deleteById(id);


    }

    public SoftwareEngineerDTO mapToDTO(SoftwareEngineer engineer) {
        return new SoftwareEngineerDTO(
                engineer.getId(),
                engineer.getName(),
                engineer.getTechStack()
        );
    }

    public List<SoftwareEngineerDTO> getEngineersByTechStack(String techStack) {
        return softwareEngineerRepository.findByTechStackContainingIgnoreCase(techStack).stream().map(engineer -> new SoftwareEngineerDTO(
                engineer.getId(),
                engineer.getName(),
                engineer.getTechStack()
                )
        ).toList();
    }

    public List<SoftwareEngineerDTO> findByNameContainingIgnoreCase(String name) {
        return softwareEngineerRepository.findByNameContainingIgnoreCase(name).stream().map(engineer -> new SoftwareEngineerDTO(
                        engineer.getId(),
                        engineer.getName(),
                        engineer.getTechStack()
                )
        ).toList();
    }

}
