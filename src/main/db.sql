CREATE OR REPLACE PACKAGE pkg_hospitales_crud AS
/*==============================================================*/
/* SISTEMA:     CRUD Hospitales             					*/
/* PAQUETE:     PKG_HOSPITALES_CRUD.sql     	                */
/* DESCRIPCION: Crud para HOSPITALES       			            */
/* AUTOR:       PALMACHRIS7							            */
/* FECHA:       02/10/2022                                      */
/*==============================================================*/
/*-------------------------------------------------------------------------------- 

	PROCEDIMIENTOS:
	--------------------------------------------------------------------------------
    INSERT	
	PROC_REGISTRAR_HOSPITAL[REGISTROS]
	--------------------------------------------------------------------------------
    UPDATE
    PROC_ACTUALIZAR_HOSPITAL[REGISTROS]
    --------------------------------------------------------------------------------
    Statement  DELETE
	PROC_ELIMINAR_HOSPITAL[Key]
	--------------------------------------------------------------------------------*/
/*==============================================================*/

    PROCEDURE proc_registrar_hospital (
        pidhospital    IN NUMBER,
        pantiguedad    IN NUMBER,
        parea          IN FLOAT,
        pfecharegistro IN TIMESTAMP,
        pnombre        IN VARCHAR2,
        pidecondicion  IN NUMBER,
        piddistrito    IN NUMBER,
        pidgerente     IN NUMBER,
        pidsede        IN NUMBER,
        pimagen        IN VARCHAR2,
        pdetalles      IN VARCHAR2
    );

    PROCEDURE proc_actualizar_hospital (
        pidhospital    IN NUMBER,
        pantiguedad    IN NUMBER,
        parea          IN FLOAT,
        pfecharegistro IN TIMESTAMP,
        pnombre        IN VARCHAR2,
        pidecondicion  IN NUMBER,
        piddistrito    IN NUMBER,
        pidgerente     IN NUMBER,
        pidsede        IN NUMBER,
        pimagen        IN VARCHAR2,
        pdetalles      IN VARCHAR2
    );

    PROCEDURE proc_eliminar_hospital (
        pidhospital IN NUMBER
    );

    PROCEDURE proc_buscar_hospital (
        pnombre             IN VARCHAR2,
        pidsede             IN NUMBER,
        cur_list_hospitales_b OUT SYS_REFCURSOR
    );

    PROCEDURE proc_listar_hospital (
        cur_list_hospitales OUT SYS_REFCURSOR
    );

    PROCEDURE proc_listar_hospital_id (
        pidhospital            IN NUMBER,
        cur_list_hospitales_id OUT SYS_REFCURSOR
    );

END pkg_hospitales_crud;
/

CREATE OR REPLACE PACKAGE BODY pkg_hospitales_crud AS 
/*==============================================================*/
/* SISTEMA:     CRUD Hospitales             					*/
/* PAQUETE:     PKG_HOSPITALES_CRUD.sql     	                */
/* DESCRIPCION: Crud para HOSPITALES       			            */
/* AUTOR:       PALMACHRIS7							            */
/* FECHA:       02/10/2022                                      */
/*==============================================================*/
  -----------------------------------------------------------------------------
    -- INSERT	
	-- PROC_REGISTRAR_HOSPITAL[REGISTROS]
  -----------------------------------------------------------------------------
    PROCEDURE proc_registrar_hospital( 
        pidhospital    IN NUMBER,
        pantiguedad    IN NUMBER,
        parea          IN FLOAT,
        pfecharegistro IN TIMESTAMP,
        pnombre        IN VARCHAR2,
        pidecondicion  IN NUMBER,
        piddistrito    IN NUMBER,
        pidgerente     IN NUMBER,
        pidsede        IN NUMBER,
        pimagen        IN VARCHAR2,
        pdetalles      IN VARCHAR2
    ) IS
    BEGIN
        INSERT INTO hospital (
            idhospital,
            antiguedad,
            area,
            fecharegistro,
            nombre,
            idecondicion,
            iddistrito,
            idgerente,
            idsede,
            imagen,
            detalles
        ) VALUES (
            pidhospital,
            pantiguedad,
            parea,
            pfecharegistro,
            pnombre,
            pidecondicion,
            piddistrito,
            pidgerente,
            pidsede,
            pimagen,
            pdetalles
        );

    END proc_registrar_hospital;
  -----------------------------------------------------------------------------
    -- UPDATE
    -- PROC_ACTUALIZAR_HOSPITAL[REGISTROS]
  -----------------------------------------------------------------------------
    PROCEDURE proc_actualizar_hospital (
        pidhospital    IN NUMBER,
        pantiguedad    IN NUMBER,
        parea          IN FLOAT,
        pfecharegistro IN TIMESTAMP,
        pnombre        IN VARCHAR2,
        pidecondicion  IN NUMBER,
        piddistrito    IN NUMBER,
        pidgerente     IN NUMBER,
        pidsede        IN NUMBER,
        pimagen        IN VARCHAR2,
        pdetalles      IN VARCHAR2
    ) IS
    BEGIN
        UPDATE hospital
        SET
            idhospital = pidhospital,
            antiguedad = pantiguedad,
            area = parea,
            fecharegistro = pfecharegistro,
            nombre = pnombre,
            idecondicion = pidecondicion,
            iddistrito = piddistrito,
            idgerente = pidgerente,
            idsede = pidsede,
            imagen = pimagen,
            detalles = pdetalles
        WHERE
            idhospital = pidhospital;

    END proc_actualizar_hospital;

  -----------------------------------------------------------------------------
    --DELETE
	--PROC_ELIMINAR_HOSPITAL[Key]
  -----------------------------------------------------------------------------
    PROCEDURE proc_eliminar_hospital (
        pidhospital IN NUMBER
    ) IS
    BEGIN
        DELETE hospital
        WHERE
            idhospital = pidhospital;

    END proc_eliminar_hospital;
    
-------------------------------------------------------------------------------
    --Buscar
  --   PROC_BUSCAR_HOSPITAL[key]
-------------------------------------------------------------------------------
    PROCEDURE proc_buscar_hospital (
        pnombre             IN VARCHAR2,
        pidsede             IN NUMBER,
        cur_list_hospitales_b OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN cur_list_hospitales_b FOR 
                         SELECT
                             *
                            FROM
                            hospital
                            WHERE
                            nombre = pnombre or idsede=pidsede;

    END proc_buscar_hospital;

-------------------------------------------------------------------------------
    --Listar
  --   PROC_LISTAR_HOSPITAL_ID[key]
-------------------------------------------------------------------------------
    PROCEDURE proc_listar_hospital_id (
        pidhospital            IN NUMBER,
        cur_list_hospitales_id OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN cur_list_hospitales_id FOR 
    SELECT
     "A1"."IDHOSPITAL"    "IDHOSPITAL",
    "A1"."ANTIGUEDAD"    "ANTIGUEDAD",
    "A1"."AREA"          "AREA",
    "A1"."FECHAREGISTRO" "FECHAREGISTRO",
    "A1"."NOMBRE"        "NOMBRE",
    "A1"."IDECONDICION"  "IDECONDICION",
    "A1"."IDDISTRITO"    "IDDISTRITO",
    "A1"."IDGERENTE"     "IDGERENTE",
    "A1"."IDSEDE"        "IDSEDE",
    "A1"."IMAGEN"        "IMAGEN",
    "A1"."DETALLES"      "DETALLES"
    
    FROM
        "SYS"."HOSPITAL" "A1"
    WHERE
       idhospital = pidhospital;

    END proc_listar_hospital_id;

-------------------------------------------------------------------------------
    --Listar
  --   PROC_LISTAR_HOSPITAL[key]
-------------------------------------------------------------------------------
    PROCEDURE proc_listar_hospital (
        cur_list_hospitales OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN cur_list_hospitales FOR 
    SELECT
    "A1"."IDHOSPITAL"    "IDHOSPITAL",
    "A1"."ANTIGUEDAD"    "ANTIGUEDAD",
    "A1"."AREA"          "AREA",
    "A1"."FECHAREGISTRO" "FECHAREGISTRO",
    "A1"."NOMBRE"        "NOMBRE",
    "A1"."IDECONDICION"  "IDECONDICION",
    "A1"."IDDISTRITO"    "IDDISTRITO",
    "A1"."IDGERENTE"     "IDGERENTE",
    "A1"."IDSEDE"        "IDSEDE",
    "A1"."IMAGEN"        "IMAGEN",
    "A1"."DETALLES"      "DETALLES"
FROM
    "SYS"."HOSPITAL" "A1";

    END proc_listar_hospital;

END pkg_hospitales_crud;