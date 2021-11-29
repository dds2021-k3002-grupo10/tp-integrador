package com.disenio.model.publicaciones;

import com.disenio.model.mascotas.MascotaHogarTransito;
import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.model.personas.Persona;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("perdida")
public class PublicacionPerdida extends Publicacion implements Serializable {


    private MascotaRescatada mascota;
    private MascotaHogarTransito hogar;
    private Estado estado;


    //Constructors
    protected PublicacionPerdida(Persona autor) {
        super(autor);
        this.estado = Estado.PENDIENTE;
    }

    public PublicacionPerdida(Persona autor, MascotaRescatada mascota, MascotaHogarTransito hogar) {
        super(autor);
        this.mascota = mascota;
        this.hogar = hogar;
    }

    public PublicacionPerdida() {
    }


    //Accessors

    @OneToOne
    @JoinColumn(name = "ID_MASCOTA_RESCATADA",nullable = true)
    public MascotaRescatada getMascota() {
        return mascota;
    }

    public void setMascota(MascotaRescatada mascota) {
        this.mascota = mascota;
    }

    @ManyToOne
    @JoinColumn(name = "ID_HOGAR",nullable = true)
    public MascotaHogarTransito getHogar() {
        return hogar;
    }

    public void setHogar(MascotaHogarTransito hogar) {
        this.hogar = hogar;
    }

    @Enumerated(value = EnumType.STRING)
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //Funcionalidad
    public void aprobar() {
        this.estado = Estado.APROBADO;
    }

    public void rechazar() {
        this.estado = Estado.RECHAZADO;
    }

    @Override
    public void contactar() {
        /*TODO Magia para contactar*/
    }
}
