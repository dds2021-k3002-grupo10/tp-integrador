package com.disenio.model.usuarios.rol;

import com.disenio.model.usuarios.Rol;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("voluntario")
public class Voluntario extends Rol {
    public Voluntario() {
        this.estado = 'A';
        this.descripcion = "VOLUNTARIO";
    }

    @Override
    public Boolean permisoDeEdicion() {
        return true;
    }

    @Override
    public Boolean permisoAprobacion() {
        return true;
    }
}
