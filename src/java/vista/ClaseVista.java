/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.ClaseLogicaLocal;
import modelo.Clase;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author jsnar
 */
@Named(value = "claseVista")
@RequestScoped
public class ClaseVista {

    private InputText txtNumero;
    private InputText txtFecha;
    private InputText txtAsignatura;
    private InputText txtTema;
    private InputText txtHoraInicio;
    private InputText txtHoraFin;
    private InputText txtProfesor;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    private List<Clase> listaClases;
    private Clase selectedClase;
    
    @EJB
    private ClaseLogicaLocal claseLogica;

    public InputText getTxtNumero() {
        return txtNumero;
    }

    public void setTxtNumero(InputText txtNumero) {
        this.txtNumero = txtNumero;
    }

    public InputText getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(InputText txtFecha) {
        this.txtFecha = txtFecha;
    }

    public InputText getTxtAsignatura() {
        return txtAsignatura;
    }

    public void setTxtAsignatura(InputText txtAsignatura) {
        this.txtAsignatura = txtAsignatura;
    }

    public InputText getTxtTema() {
        return txtTema;
    }

    public void setTxtTema(InputText txtTema) {
        this.txtTema = txtTema;
    }

    public InputText getTxtHoraInicio() {
        return txtHoraInicio;
    }

    public void setTxtHoraInicio(InputText txtHoraInicio) {
        this.txtHoraInicio = txtHoraInicio;
    }

    public InputText getTxtHoraFin() {
        return txtHoraFin;
    }

    public void setTxtHoraFin(InputText txtHoraFin) {
        this.txtHoraFin = txtHoraFin;
    }

    public InputText getTxtProfesor() {
        return txtProfesor;
    }

    public void setTxtProfesor(InputText txtProfesor) {
        this.txtProfesor = txtProfesor;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public List<Clase> getListaClases() {
        if(listaClases == null) {
            try {
                listaClases = claseLogica.consultarTodas();
            } catch (Exception ex) {
                Logger.getLogger(ClaseVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaClases;
    }

    public void setListaClases(List<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    public Clase getSelectedClase() {
        return selectedClase;
    }

    public void setSelectedClase(Clase selectedClase) {
        this.selectedClase = selectedClase;
    }

    // Mostrar por interfaz la clase seleccionada
    public void onRowSelect(SelectEvent event) {
        this.selectedClase = (Clase) event.getObject();
        this.txtNumero.setValue(selectedClase.getNumero());
        this.txtFecha.setValue(selectedClase.getFecha());
        this.txtAsignatura.setValue(selectedClase.getAsignatura());
        this.txtTema.setValue(selectedClase.getTema());
        this.txtHoraInicio.setValue(selectedClase.getHorainicio());
        this.txtHoraFin.setValue(selectedClase.getHorafin());
        this.txtProfesor.setValue(selectedClase.getProfesor());
        
        // Se deshabilita el botón registrar para permitir que la clase se puede modificar o eliminar       
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
        this.txtNumero.setDisabled(true);
    }

    // Limpia los campos y reinicia los valores
    public void limpiar(){
        this.txtNumero.setValue("");
        this.txtFecha.setValue("");
        this.txtAsignatura.setValue("");
        this.txtTema.setValue("");
        this.txtHoraInicio.setValue("");
        this.txtHoraFin.setValue("");
        this.txtProfesor.setValue("");
        this.txtNumero.setDisabled(false);
        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);
    }

    // Método registrar
    public void action_registrar(){
        try {
            Clase objClase = new Clase();
            objClase.setNumero(Integer.parseInt(this.txtNumero.getValue().toString()));
            objClase.setFecha(Date.valueOf(this.txtFecha.getValue().toString()));
            objClase.setAsignatura(this.txtAsignatura.getValue().toString());
            objClase.setTema(this.txtTema.getValue().toString());
            objClase.setHorainicio(Date.valueOf(this.txtHoraInicio.getValue().toString()));
            objClase.setHorafin(Date.valueOf(this.txtHoraFin.getValue().toString()));
            objClase.setProfesor(this.txtProfesor.getValue().toString());
            
            claseLogica.registrarClase(objClase);
            listaClases = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información de creación de clase", "La clase fue registrada con éxito."));
            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }
    }

    // Método modificar
    public void action_modificar(){
        try {
            Clase objClase = new Clase();
            objClase.setNumero(Integer.parseInt(this.txtNumero.getValue().toString()));
            objClase.setFecha(Date.valueOf(this.txtFecha.getValue().toString()));
            objClase.setAsignatura(this.txtAsignatura.getValue().toString());
            objClase.setTema(this.txtTema.getValue().toString());
            objClase.setHorainicio(Date.valueOf(this.txtHoraInicio.getValue().toString()));
            objClase.setHorafin(Date.valueOf(this.txtHoraFin.getValue().toString()));
            objClase.setProfesor(this.txtProfesor.getValue().toString());
            
            claseLogica.modificarClase(objClase);
            listaClases = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información de modificación de clase", "La clase fue modificada con éxito."));
            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }
    }    
 
    // Método eliminar
    public void action_eliminar(){
        try {
            Clase objClase = new Clase();
            objClase.setNumero(Integer.parseInt(this.txtNumero.getValue().toString()));
            objClase.setFecha(Date.valueOf(this.txtFecha.getValue().toString()));
            objClase.setAsignatura(this.txtAsignatura.getValue().toString());
            objClase.setTema(this.txtTema.getValue().toString());
            objClase.setHorainicio(Date.valueOf(this.txtHoraInicio.getValue().toString()));
            objClase.setHorafin(Date.valueOf(this.txtHoraFin.getValue().toString()));
            objClase.setProfesor(this.txtProfesor.getValue().toString());
            
            claseLogica.eliminarClase(objClase);
            listaClases = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información de eliminación de clase", "La clase fue eliminada con éxito."));
            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }
    }
    
    /**
     * Creates a new instance of ClaseVista
     */
    public ClaseVista() {
    }
    
}
