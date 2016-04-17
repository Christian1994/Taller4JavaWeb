/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Clase;
import persistencia.ClaseFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class ClaseLogica implements ClaseLogicaLocal {

    @EJB
    ClaseFacadeLocal claseDAO;
    
    @Override
    public void registrarClase(Clase clase) throws Exception {
        if(clase == null){
            throw new Exception("Campos vacíos.");
        }
        else{
            if(clase.getNumero() == 0 || clase.getNumero() == null){
                throw new Exception("Campo Numero obligatorio.");
            }
            if(clase.getFecha() == null){
                throw new Exception("Campo Nombre obligatorio.");
            }
            if(clase.getAsignatura() == null || clase.getAsignatura().equals("")){
                throw new Exception("Campo Asignatura obligatorio.");
            }
            if(clase.getTema() == null || clase.getTema().equals("")){
                throw new Exception("Campo Tema obligatorio.");
            }
            if(clase.getHorainicio() == null){
                throw new Exception("Campo Hora Inicio obligatorio.");
            }
            if(clase.getHorafin() == null){
                throw new Exception("Campo Hora Fin obligatorio.");
            }
            if(clase.getProfesor() == null || clase.getProfesor().equals("")){
                throw new Exception("Campo Profesor obligatorio.");
            }
        }
        
        Clase objClase = claseDAO.find(clase.getNumero());
        if(objClase != null){
            throw new Exception("Clase ya existe.");
        }
        else{
            claseDAO.create(clase);
        }
    }

    @Override
    public void modificarClase(Clase clase) throws Exception {
        if(clase == null){
            throw new Exception("Campos vacíos.");
        }
        else{
            if(clase.getNumero() == 0 || clase.getNumero() == null){
                throw new Exception("Campo Numero obligatorio.");
            }
            if(clase.getFecha() == null){
                throw new Exception("Campo Nombre obligatorio.");
            }
            if(clase.getAsignatura() == null || clase.getAsignatura().equals("")){
                throw new Exception("Campo Asignatura obligatorio.");
            }
            if(clase.getTema() == null || clase.getTema().equals("")){
                throw new Exception("Campo Tema obligatorio.");
            }
            if(clase.getHorainicio() == null){
                throw new Exception("Campo Hora Inicio obligatorio.");
            }
            if(clase.getHorafin() == null){
                throw new Exception("Campo Hora Fin obligatorio.");
            }
            if(clase.getProfesor() == null || clase.getProfesor().equals("")){
                throw new Exception("Campo Profesor obligatorio.");
            }
        }
        
        Clase objClase = claseDAO.find(clase.getNumero());
        if(objClase == null){
            throw new Exception("Clase a modificar no existe.");
        }
        else{
            objClase.setFecha(clase.getFecha());
            objClase.setAsignatura(clase.getAsignatura());
            objClase.setTema(clase.getTema());
            objClase.setHorainicio(clase.getHorainicio());
            objClase.setHorafin(clase.getHorafin());
            objClase.setProfesor(clase.getProfesor());
            claseDAO.edit(clase);
        }
    }

    @Override
    public void eliminarClase(Clase clase) throws Exception {
        if(clase == null){
            throw new Exception("Campos vacíos.");
        }
        else{
            if(clase.getNumero() == 0 || clase.getNumero() == null){
                throw new Exception("Campo Numero obligatorio.");
            }
        }
        
        Clase objClase = claseDAO.find(clase.getNumero());
        if(objClase == null){
            throw new Exception("Clase a eliminar no existe.");
        }
        else{
            claseDAO.remove(clase);
        }
    }

    @Override
    public Clase consultarxCodigo(Integer codigo) throws Exception {
        if(codigo == 0 || codigo == null){
            throw new Exception("Campo Documento obligatorio.");
        }
        else{
            return claseDAO.find(codigo);
        }
    }

    @Override
    public List<Clase> consultarTodas() throws Exception {
        return claseDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
