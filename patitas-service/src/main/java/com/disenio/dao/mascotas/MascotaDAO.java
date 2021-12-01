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

    @Query("select m from Mascota m where m.persona.idPersona= :idPersona")
    Optional<List<Mascota>> MascotasSegunID(Integer idPersona);

    @Query("select m from Mascota m inner join PersonaDocumento pd  on  pd.persona.idPersona = m.persona.idPersona where pd.numero= :numero and pd.tipoDocumento.idTipoDoc= :idTipoDoc")
    List<Mascota> getMascotaByPersonasByCondicion(Integer idTipoDoc,Integer numero);

}
