package com.palma.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palma.app.models.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede,Long>{
    
}
