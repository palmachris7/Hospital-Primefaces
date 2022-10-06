package com.palma.app.viewcontroller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


import com.palma.app.models.Hospital;
import com.palma.app.models.Sede;
import com.palma.app.repositories.HospitalRepository;
import com.palma.app.repositories.SedeRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
@ViewScoped
@Data
public class HospitalViewController {

    private HospitalRepository hospitalRepository;
    private SedeRepository sedeRepository;
    private List<Hospital> hospitales;
    private Hospital hospital;
    private List<Sede> sedes;
    private Sede sede;



    @Autowired
    public void setHospitalRepository(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Autowired
    public void setSedeRepository(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    
    @PostConstruct 
    public void init() {
        hospital = new Hospital();
       hospitales = hospitalRepository.listarHospitalpro();
     //hospitales = hospitalRepository.findAll();
        sedes = sedeRepository.findAll();
    }

    public String gotoCreateHospital() {
        return "create-hospital.xhtml?faces-redirect=true";
    }

    public String regresar() {
        hospitales = hospitalRepository.findAll();
        return "index.xhtml?faces-redirect=true";
    }

    public String editar(Long idHospital, Model model) {
        Optional<Hospital> optional = hospitalRepository.findById(idHospital);
        Hospital hospital = optional.get();
        model.addAttribute("hospital", hospital);

        // hospital = hospitalRepository.findById(valor);
        return "create-hospital.xhtml?faces-redirect=true";
    }

    public String saveHospital() {
        hospitalRepository.save(hospital);
        hospitales = hospitalRepository.findAll();
        return "index.xhtml?faces-redirect=true";
    }

    public String eliminar(Long idHospital) {
        hospitalRepository.deleteHospital(idHospital);
        hospitales = hospitalRepository.findAll();
        return "index.xhtml?faces-redirect=true";
    }
    @RequestMapping(value="obtieneTitulo", params="idDisco")
	public @ModelAttribute("tituloDisco") Hospital obtieneTituloDisco(@ModelAttribute String nombre,@ModelAttribute Integer sede) {
		Optional<Hospital> optional=hospitalRepository.searchHospital(nombre,sede);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
