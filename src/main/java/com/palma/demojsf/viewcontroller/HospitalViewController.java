package com.palma.demojsf.viewcontroller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import com.palma.demojsf.models.Hospital;
import com.palma.demojsf.repositories.HospitalRepository;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
@Data
public class HospitalViewController {

    private HospitalRepository hospitalRepository;
    private List<Hospital> hospitales;
    private Hospital hospital;


    @Autowired
    public void setHospitalRepository(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    
    @PostConstruct
    public void init() {
        hospital = new Hospital();
        hospitales = hospitalRepository.findAll();
    }

    public String gotoCreateHospital() {
        return "create-hospital.xhtml?faces-redirect=true";
    }

    public String saveHospital() {
        hospitalRepository.save(hospital);
        hospitales = hospitalRepository.findAll();
        return "index.xhtml?faces-redirect=true";
    }
}
