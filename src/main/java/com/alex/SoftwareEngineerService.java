package com.alex;


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

    /*Get all software engineers */
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }
    /*Insert one software engineer*/
    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    /*Delete one software engineer */
    public SoftwareEngineer getSoftwareEngineerById(Integer id) {

        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException( id + " not found"));
    }

    /*Update a software engineer */
    public SoftwareEngineer putSoftwareEngineerById(Integer id, SoftwareEngineer data) {

        SoftwareEngineer existingEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Engineer" + id + " not found"));

        existingEngineer.setName(data.getName());
        existingEngineer.setTechStack(data.getTechStack());

        return softwareEngineerRepository.save(existingEngineer);


    }

    /*Delete a software engineer */
    public void deleteSoftwareEngineerById(Integer id) {
        SoftwareEngineer engineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Engineer" + id + " not found"));

        softwareEngineerRepository.deleteById(id);


    }
}
