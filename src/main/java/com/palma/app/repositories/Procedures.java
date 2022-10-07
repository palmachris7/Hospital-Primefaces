package com.palma.app.repositories;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.palma.app.models.Hospital;

@Repository
public class Procedures {
	private EntityManager entityManager;
 
    @Autowired
    public Procedures(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 
	

	

	// public List<Hospital> buscarTodos() {
	// 	entityManager.getTransaction().begin();
	// 	StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("PKG_CRUD_HOSPITAL.PROC_LISTAR_HOSPITAL", Hospital.class);
	// 	procedureQuery.registerStoredProcedureParameter("cur_list_hospitales", void.class, ParameterMode.REF_CURSOR);
	// 	procedureQuery.execute();
	// 	List<Hospital> listahospitales = procedureQuery.getResultList();
	// 	entityManager.getTransaction().commit();
	// 	return listahospitales;
	// }
  

	// public void guardar(Hospital hospital) {
	// 	StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("PKG_HOSPITALES_CRUD.PROC_REGISTRAR_HOSPITAL");
	// 	procedureQuery.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
	// 	procedureQuery.registerStoredProcedureParameter("P_ANTIGUEDAD", Integer.class, ParameterMode.IN);
	// 	procedureQuery.registerStoredProcedureParameter("P_AREA", Double.class, ParameterMode.IN);
	// 	procedureQuery.registerStoredProcedureParameter("P_FECHAREGISTRO", Date.class, ParameterMode.IN);
	// 	procedureQuery.registerStoredProcedureParameter("P_IDDISTRITO", Integer.class, ParameterMode.IN);
	// 	procedureQuery.registerStoredProcedureParameter("P_IDSEDE", Integer.class, ParameterMode.IN);
	// 	procedureQuery.registerStoredProcedureParameter("P_IDGERENTE", Integer.class, ParameterMode.IN);
	// 	procedureQuery.registerStoredProcedureParameter("P_IDCONDICION", Integer.class, ParameterMode.IN);
	// 	procedureQuery.registerStoredProcedureParameter("P_MENSAJE", String.class, ParameterMode.OUT);
	// 	entityManager.getTransaction().begin();
	// 	procedureQuery.setParameter("P_NOMBRE", hospital.getNombre());
	// 	procedureQuery.setParameter("P_ANTIGUEDAD", hospital.getAntiguedad());
	// 	procedureQuery.setParameter("P_AREA", hospital.getArea());
	// 	procedureQuery.setParameter("P_FECHAREGISTRO", hospital.getFecharegistro());
	// 	procedureQuery.setParameter("P_IDDISTRITO", hospital.getDistrito().getIddistrito());
	// 	procedureQuery.setParameter("P_IDSEDE", hospital.getSede().getIdsede());
	// 	procedureQuery.setParameter("P_IDGERENTE", hospital.getGerente().getIdgerente());
	// 	procedureQuery.setParameter("P_IDCONDICION", hospital.getCondicion().getIdcondicion());
	// 	procedureQuery.execute();
	// 	entityManager.getTransaction().commit();
	// }
	
	

	





}
