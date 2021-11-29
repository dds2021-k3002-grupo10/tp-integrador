package com.disenio.services.mascotas;

import com.disenio.model.mascotas.MascotaHogarTransito;
import com.disenio.model.publicaciones.Publicacion;

import java.util.List;
import java.util.Optional;

public interface HogarTransitoService {
    public MascotaHogarTransito alta(MascotaHogarTransito o);

    public List<MascotaHogarTransito> listarTodas();

    public Optional<MascotaHogarTransito> getById(Integer id);
}
