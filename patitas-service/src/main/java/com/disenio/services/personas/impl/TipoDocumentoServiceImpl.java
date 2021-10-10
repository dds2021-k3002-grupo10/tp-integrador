package com.disenio.services.personas.impl;

import com.disenio.dao.persona.TipoDocumentoDAO;
import com.disenio.model.personas.TipoDocumento;
import com.disenio.services.personas.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    @Autowired
    TipoDocumentoDAO tipoDocumentoDAO;
    @Override
    public List<TipoDocumento> getTipoDocuemntoALl() {
        return tipoDocumentoDAO.findAll();
    }
}
