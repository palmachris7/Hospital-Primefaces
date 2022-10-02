package com.palma.app.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.ParameterMode;
import lombok.Data;

@Data
@Entity
@Table(name = "HOSPITAL")

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "addHospitalProcedure", procedureName = "ADD_HOSPITAL_PROCEDURE", resultClasses = {
				Hospital.class }, parameters = {
						@StoredProcedureParameter(name = "nombre", type = String.class, mode = ParameterMode.IN),
						@StoredProcedureParameter(name = "antiguedad", type = String.class, mode = ParameterMode.IN),
						@StoredProcedureParameter(name = "area", type = String.class, mode = ParameterMode.IN),
						@StoredProcedureParameter(name = "fecharegistro", type = Integer.class, mode = ParameterMode.IN),
						@StoredProcedureParameter(name = "imagen", type = Integer.class, mode = ParameterMode.IN),
						@StoredProcedureParameter(name = "detalles", type = Integer.class, mode = ParameterMode.IN)
				}),
		@NamedStoredProcedureQuery(name = "searchHospitalProcedure", procedureName = "SEARCH_HOSPITAL_PROCEDURE", resultClasses = {
				Hospital.class }, parameters = {
						@StoredProcedureParameter(name = "nombre", type = String.class, mode = ParameterMode.IN),
						@StoredProcedureParameter(name = "sede", type = String.class, mode = ParameterMode.IN),

		}),
		@NamedStoredProcedureQuery(name = "listarHospitalProcedure", procedureName = "LIST_HOSPITAL_PROCEDURE", resultClasses = {
				Hospital.class })
})
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idhospital;
	private String nombre;
	private Integer antiguedad;
	private Double area;
	private Date fecharegistro;
	private String imagen = "no-image.jpeg";
	private String detalles;

	@OneToOne
	@JoinColumn(name = "iddistrito")
	private Distrito distrito;

	@OneToOne
	@JoinColumn(name = "idgerente")
	private Gerente gerente;

	@OneToOne
	@JoinColumn(name = "idecondicion")
	private Condicion condicion;

	@OneToOne
	@JoinColumn(name = "idsede")
	private Sede sede;

	public void reset() {
		this.imagen = null;
	}

}
