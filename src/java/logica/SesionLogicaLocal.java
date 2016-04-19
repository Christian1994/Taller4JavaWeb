/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.Usuario;

/**
 *
 * @author jsnar
 */
@Local
public interface SesionLogicaLocal {
    public Usuario iniciarSesion(Long documento, String clave) throws Exception;
}
