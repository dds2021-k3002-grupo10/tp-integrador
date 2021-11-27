package com.disenio.services.personas;

import com.disenio.model.personas.TipoDocumento;

import java.util.List;
import java.util.Optional;

public interface TipoDocumentoService {

    List<TipoDocumento> getTipoDocuemntoALl();

    Optional<TipoDocumento> getTipoDocuemntoById(Integer id);
}
