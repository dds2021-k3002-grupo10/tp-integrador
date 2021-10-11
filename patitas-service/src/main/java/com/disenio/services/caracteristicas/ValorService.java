package com.disenio.services.caracteristicas;

import com.disenio.model.caracteristicas.Valor;

public interface ValorService {

    Valor alta(Valor valor);

    Valor getValorByID(Integer id);
}
