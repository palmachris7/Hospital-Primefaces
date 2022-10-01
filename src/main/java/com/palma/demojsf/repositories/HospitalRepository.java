package com.palma.demojsf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palma.demojsf.models.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    
}
