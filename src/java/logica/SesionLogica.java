/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Usuario;
import persistencia.UsuarioFacadeLocal;

/**
 *
 * @author jsnar
 */
@Stateless
public class SesionLogica implements SesionLogicaLocal {

    @EJB
    private UsuarioFacadeLocal usuarioDAO;
    
    @Override
    public Usuario iniciarSesion(Long documento, String clave) throws Exception {
        if(documento == null || clave == null || clave.equals("")){
            throw new Exception("Los datos de ingreso son Obligatorios.");
        }
        
        Usuario u = usuarioDAO.find(documento);
        
        if(u != null){
            if(!u.getClave().equals(clave)){
                throw new Exception("Clave incorrecta.");
            }
        }
        
        return u;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}