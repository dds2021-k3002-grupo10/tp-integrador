package com.disenio.dao.mascotas;

import com.disenio.model.mascotas.TamanioMascota;
import com.disenio.model.mascotas.TipoMascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TamanioMascotaDAO  extends JpaRepository<TamanioMascota, Integer> {
}
