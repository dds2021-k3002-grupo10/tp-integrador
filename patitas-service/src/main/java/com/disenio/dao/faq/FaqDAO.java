package com.disenio.dao.faq;

import com.disenio.model.faq.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqDAO  extends JpaRepository<Faq,Integer> {

    @Query("Select a from Faq a where a.organizacion.idOrganizacion = :idOrganizacion and a.faqPreguntaTipo.idPreguntaTipo= :idPreguntaTipo")
    List<Faq> findByOrganizacionAndPreguntaTipo(Integer idOrganizacion,Integer idPreguntaTipo);


}
