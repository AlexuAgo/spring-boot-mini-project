package com.alex;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftwareEngineerRepository
        extends JpaRepository<SoftwareEngineer, Integer>{

    Page<SoftwareEngineer> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<SoftwareEngineer> findByTechStackContainingIgnoreCase(String techStack, Pageable pageable);

    Page<SoftwareEngineer> findByNameContainingIgnoreCaseAndTechStackContainingIgnoreCase(
            String name, String techStack, Pageable pageable);
}
