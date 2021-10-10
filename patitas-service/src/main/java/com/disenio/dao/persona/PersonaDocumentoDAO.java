package com.disenio.dao.persona;

import com.disenio.model.personas.PersonaDireccion;
import com.disenio.model.personas.PersonaDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaDocumentoDAO  extends JpaRepository<PersonaDocumento, Integer> {
}

