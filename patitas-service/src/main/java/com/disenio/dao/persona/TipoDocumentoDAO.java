package com.disenio.dao.persona;

import com.disenio.model.personas.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoDAO extends JpaRepository<TipoDocumento,Integer> {
}
