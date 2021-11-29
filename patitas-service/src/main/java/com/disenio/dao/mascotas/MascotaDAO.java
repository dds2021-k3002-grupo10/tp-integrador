package com.disenio.dao.mascotas;

import com.disenio.model.mascotas.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MascotaDAO extends JpaRepository<Mascota,Integer> {

    @Query("select m from Mascota m where m.persona.idPersona= :idPersona")
    List<Mascota> MascotaByPersonasId(Integer idPersona);
}
