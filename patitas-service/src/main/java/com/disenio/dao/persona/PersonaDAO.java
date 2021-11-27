package com.disenio.dao.persona;

import com.disenio.model.personas.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PersonaDAO")
public interface PersonaDAO extends JpaRepository<Persona,Integer> {

    @Query("Select p FROM Persona p INNER JOIN PersonaDocumento pd  on pd.persona.idPersona= p.idPersona where pd.numero = :numero and pd.tipoDocumento.idTipoDoc= :idTipoDoc")
    List<Persona> findPersonasByCondicion(Integer idTipoDoc,Integer numero);





}
