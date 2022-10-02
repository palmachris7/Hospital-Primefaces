package com.palma.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.palma.app.models.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    @Procedure(name = "addHospitalProcedure")
    String procedureName(@Param("nombre") String nombre, @Param("antiguedad") String antiguedad);
    
}
