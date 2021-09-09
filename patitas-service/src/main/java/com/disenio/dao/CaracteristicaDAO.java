package com.disenio.dao;

import com.disenio.model.caracteristicas.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CaracteristicaDAO")
public interface CaracteristicaDAO extends JpaRepository<Caracteristica,Integer> {

    @Query("Select a from Caracteristica a where a.organizacion.idOrganizacion = :idOrganizacion")
    List<Caracteristica> findByOrganizacion_IdOrganizacion(Integer idOrganizacion);

}
