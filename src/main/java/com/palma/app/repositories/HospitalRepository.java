package com.palma.app.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.palma.app.models.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {

    @Procedure(name = "deleteHospital")
    String deleteHospital(@Param("id") Long idHospital);

    @Procedure(name = "searchHospital")
    Optional<Hospital> searchHospital(@Param("nombre") String nombre, @Param("sede") Integer sede);

    @Procedure(name = "listarHospital")
    List<Hospital> listarHospitalpro();

    @Procedure(name = "addHospital")
    String procedureName(@Param("nombre") String nombre, @Param("antiguedad") String antiguedad);
    String listHospital( @Param("pidhospital") Integer idhospital,
    @Param("pantiguedad") Integer antiguedad, @Param("parea") Double area, @Param("pfecharegistro") Date fecha,
    @Param("pnombre") String nombre, @Param("pidecondicion") Integer idCondicion, @Param("piddistrito") Integer idDistrito,
    @Param("pidgerente") Integer idGerente, @Param("pidsede") Integer idSede, @Param("pimagen") String imagen,
    @Param("pdetalles") String detalles);

    @Procedure(name = "editHospital")
    String updateHospital(
            @Param("pidhospital") Integer idhospital,
            @Param("pantiguedad") Integer antiguedad, @Param("parea") Double area, @Param("pfecharegistro") Date fecha,
            @Param("pnombre") String nombre, @Param("pidecondicion") Integer idCondicion, @Param("piddistrito") Integer idDistrito,
            @Param("pidgerente") Integer idGerente, @Param("pidsede") Integer idSede, @Param("pimagen") String imagen,
            @Param("pdetalles") String detalles);

}
