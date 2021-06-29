package domain;

import domain.entities.caracteristicas.Caracteristicas;
import domain.usuario.Usuario;
import domain.usuario.roles.Admin;
import domain.usuario.roles.Voluntario;
import security.services.ValidadorDeClave;

import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    private String nombre;
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Mascota> mascotasRegistradas = new ArrayList<>();
    private int anchoEstandar;
    private int largoEstandar;
    private List<Caracteristicas> caracteristicas = new ArrayList<>();
    //TODO lista de publicaciones

    public void agregarUsuario(Usuario nuevoUsuario){ usuarios.add(nuevoUsuario); }

    public void crearAdministrador(String usuario, String clave) throws Exception {
        ValidadorDeClave validador = new ValidadorDeClave();
        if(validador.esClaveValida(clave)){
            Admin rolAdmin = new Admin();
            Usuario admin = new Usuario(usuario, clave, rolAdmin);
            agregarUsuario(admin);
        }
        else
            throw new Exception(); //tirar una excepcion si la contraseña es muy debil
    }
    public void crearVoluntarios(String usuario, String clave) throws Exception {
        ValidadorDeClave validador = new ValidadorDeClave();
        if(validador.esClaveValida(clave)){
            Voluntario rolVoluntario = new Voluntario();
            Usuario voluntario = new Usuario(usuario, clave, rolVoluntario);
            agregarUsuario(voluntario);
        }
        else
            throw new Exception(); //tirar una excepcion si la contraseña es muy debil
    }
}
