package com.marcelperezrubin.clinicaodontologica.persistencia;

import com.marcelperezrubin.clinicaodontologica.logica.Usuario;
import com.marcelperezrubin.clinicaodontologica.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    /*HorarioJpaController horaJPA = new HorarioJpaController();
    OdontologoJpaController odontoJPA = new OdontologoJpaController ();
    PacienteJpaController pacJPA = new PacienteJpaController ();
    PersonaJpaController persJPA = new PersonaJpaController ();
    ResponsableJpaController respJPA = new ResponsableJpaController ();
    SecretarioJpaController secreJPA = new SecretarioJpaController ();
    TurnoJpaController turnJPA = new TurnoJpaController ();*/
    UsuarioJpaController usuJPA = new UsuarioJpaController ();

    /*public ControladoraPersistencia() {
    }*/
    
    

    public void crearUsuario(Usuario usu) {
        usuJPA.create(usu);
    }

    public List<Usuario> getUsuarios() {
      return usuJPA.findUsuarioEntities();
    }

    public void borrarUsuario(int id) {
        try {
            usuJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
        return usuJPA.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    
    
    
    
   
    
}
