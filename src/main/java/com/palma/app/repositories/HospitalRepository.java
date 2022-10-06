package com.palma.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.palma.app.models.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    @Procedure(name = "addHospital")
    String procedureName(@Param("nombre") String nombre, @Param("antiguedad") String antiguedad);

    @Procedure(name = "searchHospital")
    Optional<Hospital> searchHospital(@Param("nombre") String nombre, @Param("sede") Integer sede);

    @Procedure(name = "listarHospital")
    List<Hospital> listarHospitalpro();

    @Procedure(name = "deleteHospital")
    String deleteHospital(@Param("idhospital") Long idhospital);

    @Procedure(name = "updateHospital")
    Optional<Hospital> updateHospital(@Param("hospital") Integer idhospital);


    
}
