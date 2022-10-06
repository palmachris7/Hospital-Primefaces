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
		@NamedStoredProcedureQuery(name = "addHospitalProcedure", procedureName = "PKG_HOSPITALES_CRUD.PROC_REGISTRAR_HOSPITAL", parameters = {
			    @StoredProcedureParameter(name = "pidhospital", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "pantiguedad", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "parea", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "pfecharegistro", type = Date.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "pnombre", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "pidecondicion", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "piddistrito", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "pidgerente", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "pidsede", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "pimagen", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "pdetalles", type = String.class, mode = ParameterMode.IN)
		}),
		@NamedStoredProcedureQuery(name = "editHospitalProcedure", procedureName = "PKG_HOSPITALES_CRUD.PROC_EDITAR_HOSPITAL", parameters = {
			@StoredProcedureParameter(name = "pidhospital", type = Integer.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name = "pantiguedad", type = String.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name = "parea", type = String.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name = "pfecharegistro", type = Date.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name = "pnombre", type = String.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name = "pidecondicion", type = Integer.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name = "piddistrito", type = Integer.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name = "pidgerente", type = Integer.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name = "pidsede", type = Integer.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name = "pimagen", type = String.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name = "pdetalles", type = String.class, mode = ParameterMode.IN)
	}),
		@NamedStoredProcedureQuery(name = "searchHospital", procedureName = "PKG_HOSPITALES_CRUD.PROC_BUSCAR_HOSPITAL", resultClasses = Hospital.class, parameters = {
				@StoredProcedureParameter(name = "nombre", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "sede", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "cur_list_hospitales_b", type = Void.class)

		}),
		@NamedStoredProcedureQuery(name = "deleteHospital", procedureName = "PKG_HOSPITALES_CRUD.PROC_ELIMINAR_HOSPITAL", parameters = {
				@StoredProcedureParameter(name = "hospital", type = Integer.class, mode = ParameterMode.IN)
		}),
		@NamedStoredProcedureQuery(name = "listarHospital", procedureName = "PKG_HOSPITALES_CRUD.PROC_LISTAR_HOSPITAL", resultClasses = Hospital.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "cur_list_hospitales", type = Void.class)

		})
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
