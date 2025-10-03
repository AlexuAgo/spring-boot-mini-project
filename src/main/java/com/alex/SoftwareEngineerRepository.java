package com.alex;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftwareEngineerRepository
        extends JpaRepository<SoftwareEngineer, Integer>{

List<SoftwareEngineer> findByTechStackContainingIgnoreCase(String techStack);

List<SoftwareEngineer> findByNameContainingIgnoreCase(String name);

}
