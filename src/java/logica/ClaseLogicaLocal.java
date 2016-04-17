/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Clase;

/**
 *
 * @author NOREÑA
 */
@Local
public interface ClaseLogicaLocal {
    public void registrarClase(Clase clase) throws Exception;
    public void modificarClase(Clase clase) throws Exception;
    public void eliminarClase(Clase clase) throws Exception;
    public Clase consultarxDocumento (Integer documento) throws Exception;
    public List<Clase> consultarTodos() throws Exception;     
}
