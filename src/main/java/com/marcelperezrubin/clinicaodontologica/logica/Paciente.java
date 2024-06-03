package com.marcelperezrubin.clinicaodontologica.logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author marcelrubin
 */

//Clase hija

@Entity
public class Paciente extends Persona implements Serializable {
    
    //private int id_paciente;
    private boolean tiene_SS;
    private String tipoSangre;
    //Haciendo la relacion 1 a 1
    @OneToOne
    private Responsable unResponsable;
    // haciendo la relacion 1 a N
    @OneToMany (mappedBy="pacien")
    private List<Turno> listaTurnos;

    public Paciente() {
    }

    public Paciente(boolean tiene_SS, String tipoSangre, Responsable unResponsable, List<Turno> listaTurnos, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.tiene_SS = tiene_SS;
        this.tipoSangre = tipoSangre;
        this.unResponsable = unResponsable;
        this.listaTurnos = listaTurnos;
    }

    
   
    
    
    // Getters & setters

    public Responsable getUnResponsable() {
        return unResponsable;
    }

    public void setUnResponsable(Responsable unResponsable) {
        this.unResponsable = unResponsable;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }


    public boolean isTiene_SS() {
        return tiene_SS;
    }

    public void setTiene_SS(boolean tiene_SS) {
        this.tiene_SS = tiene_SS;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    
    
    
}
