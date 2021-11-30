package com.disenio.model.usuarios.rol;

import com.disenio.model.usuarios.Rol;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("estandar")
public class Estandar extends Rol {

    public Estandar() {
        this.estado='A';
        this.descripcion="ESTANDAR";
    }

    @Override
    public Boolean permisoDeEdicion() {
        return false;
    }

    @Override
    public Boolean permisoAprobacion() {
        return false;
    }
}
