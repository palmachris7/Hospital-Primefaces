package com.palma.app.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.NamedStoredProcedureQueries;


import lombok.Data;
@Data
@Entity
@Table(name = "SEDE")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "listarSedeProcedure", procedureName = "LIST_SEDE_PROCEDURE", resultClasses = {
		Sede.class })
})
public class Sede {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO) // auto_increment 
	private Integer idsede;
	private String descsede;
	private Date fecharegistro;
}
