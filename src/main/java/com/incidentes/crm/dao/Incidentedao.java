package com.incidentes.crm.dao;

import com.incidentes.crm.entities.Incidente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Incidentedao extends JpaRepository <Incidente, Integer> {
    @Query("select x from Incidente x where x.status = 'Ativo' ")
    public List<Incidente> findbyStatusAtivos();

    @Query("select x from Incidente x where x.status = 'Inativo' ")
    public List<Incidente> findbyStatusInativos();

    public List<Incidente>findByNameContainingIgnoreCase(String name);

}
