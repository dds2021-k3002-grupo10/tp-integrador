package com.disenio.model.organizacion.gestores;

import com.disenio.model.cuestionario.Cuestionario;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "gestor_global" //, catalog = "patitas"
)
public class GestorGlobal {

    private static GestorGlobal instancia = null;

    private Integer id;

    private Cuestionario cuestionarioGlobal;


    /*Constructor*/
    protected GestorGlobal() {
    }


    /*Accessors*/

    @Transient
    public static GestorGlobal getInstancia() {
        if (instancia == null) {
            instancia = new GestorGlobal();
        }
        return instancia;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "cuestionario"/*,  nullable = false*/)//TODO CAmbiar
    public Cuestionario getCuestionarioGlobal() {
        return cuestionarioGlobal.clone();
    }

    public void setCuestionarioGlobal(Cuestionario cuestionarioGlobal) {
        this.cuestionarioGlobal = cuestionarioGlobal;
    }

}
