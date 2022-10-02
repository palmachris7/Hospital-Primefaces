package com.palma.app.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "CONDICION")
public class Condicion {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer idcondicion;
	private String descondicion;
	private Date fecharegistro;
}
