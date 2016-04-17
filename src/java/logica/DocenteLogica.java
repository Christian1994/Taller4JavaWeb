/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Docente;
import persistencia.DocenteFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class DocenteLogica implements DocenteLogicaLocal {

    @EJB
    DocenteFacadeLocal docenteDAO;
    
    @Override
    public void registrarDocente(Docente docente) throws Exception {
        if(docente == null){
            throw new Exception("Campos vacíos.");
        }
        else{
            if(docente.getDocumento() == 0 || docente.getDocumento() == null){
                throw new Exception("Campo Documento obligatorio.");
            }
            if(docente.getNombre() == null || docente.getNombre().equals("")){
                throw new Exception("Campo Nombre obligatorio.");
            }
            if(docente.getApellido() == null || docente.getApellido().equals("")){
                throw new Exception("Campo Docente obligatorio.");
            }
            if(docente.getCorreo() == null || docente.getCorreo().equals("")){
                throw new Exception("Campo Correo obligatorio.");
            }
            if(docente.getTelefono() == 0){
                throw new Exception("Campo Teléfono obligatorio.");
            }
        }
        
        Docente objDocente = docenteDAO.find(docente.getDocumento());
        if(objDocente != null){
            throw new Exception("Docente ya existe.");
        }
        else{
            docenteDAO.create(docente);
        }
    }

    @Override
    public void modificarDocente(Docente docente) throws Exception {
        if(docente == null){
            throw new Exception("Campos vacíos.");
        }
        else{
            if(docente.getDocumento() == 0 || docente.getDocumento() == null){
                throw new Exception("Campo Documento obligatorio.");
            }
            if(docente.getNombre() == null || docente.getNombre().equals("")){
                throw new Exception("Campo Nombre obligatorio.");
            }
            if(docente.getApellido() == null || docente.getApellido().equals("")){
                throw new Exception("Campo Docente obligatorio.");
            }
            if(docente.getCorreo() == null || docente.getCorreo().equals("")){
                throw new Exception("Campo Correo obligatorio.");
            }
            if(docente.getTelefono() == 0){
                throw new Exception("Campo Teléfono obligatorio.");
            }
        }
        
        Docente objDocente = docenteDAO.find(docente.getDocumento());
        if(objDocente == null){
            throw new Exception("Docente a modificar no existe.");
        }
        else{
            objDocente.setNombre(docente.getNombre());
            objDocente.setApellido(docente.getApellido());
            objDocente.setCorreo(docente.getCorreo());
            objDocente.setTelefono(docente.getTelefono());
            docenteDAO.edit(docente);
        }
    }

    @Override
    public void eliminarDocente(Docente docente) throws Exception {
        if(docente == null){
            throw new Exception("Campos vacíos.");
        }
        else{
            if(docente.getDocumento() == 0 || docente.getDocumento() == null){
                throw new Exception("Campo Documento obligatorio.");
            }
        }
        
        Docente objDocente = docenteDAO.find(docente.getDocumento());
        if(objDocente == null){
            throw new Exception("Docente a eliminar no existe.");
        }
        else{
            docenteDAO.remove(docente);
        }
    }

    @Override
    public Docente consultarxDocumento(Integer documento) throws Exception {
        if(documento == 0 || documento == null){
            throw new Exception("Campo Documento obligatorio.");
        }
        else{
            return docenteDAO.find(documento);
        }
    }

    @Override
    public List<Docente> consultarTodos() throws Exception {
        return docenteDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
