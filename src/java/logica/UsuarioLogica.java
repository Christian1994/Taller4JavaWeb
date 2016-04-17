/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Usuario;
import persistencia.UsuarioFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class UsuarioLogica implements UsuarioLogicaLocal {

    @EJB
    UsuarioFacadeLocal usuarioDAO;
    
    @Override
    public void registrarUsuario(Usuario usuario) throws Exception {
        if(usuario == null){
            throw new Exception("Campos vacíos.");
        }
        else{
            if(usuario.getDocumento() == 0 || usuario.getDocumento() == null){
                throw new Exception("Campo Documento obligatorio.");
            }
            if(usuario.getDependencia().equals("") || usuario.getDependencia() == null){
                throw new Exception("Campo Dependencia obligatorio.");
            }
            if(usuario.getClave().equals("") || usuario.getClave() == null){
                throw new Exception("Campo Clave obligatorio.");
            }
        }
        
        Usuario objUsuario = usuarioDAO.find(usuario.getDocumento());
        if(objUsuario != null){
            throw new Exception("Usuario ya existe.");
        }
        else{
            usuarioDAO.create(usuario);
        }
    }

    @Override
    public void modificarUsuario(Usuario usuario) throws Exception {
        if(usuario == null){
            throw new Exception("Campos vacíos.");
        }
        else{
            if(usuario.getDocumento() == 0 || usuario.getDocumento() == null){
                throw new Exception("Campo Documento obligatorio.");
            }
            if(usuario.getDependencia().equals("") || usuario.getDependencia() == null){
                throw new Exception("Campo Dependencia obligatorio.");
            }
            if(usuario.getClave().equals("") || usuario.getClave() == null){
                throw new Exception("Campo Clave obligatorio.");
            }
        }
        
        Usuario objUsuario = usuarioDAO.find(usuario.getDocumento());
        if(objUsuario == null){
            throw new Exception("Usuario a modificar no existe.");
        }
        else{
            objUsuario.setDependencia(usuario.getDependencia());
            objUsuario.setClave(usuario.getClave());
            usuarioDAO.edit(usuario);
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) throws Exception {
        if(usuario == null){
            throw new Exception("Campos vacíos.");
        }
        else{
            if(usuario.getDocumento() == 0 || usuario.getDocumento() == null){
                throw new Exception("Campo Documento obligatorio.");
            }
        }
        
        Usuario objUsuario = usuarioDAO.find(usuario.getDocumento());
        if(objUsuario == null){
            throw new Exception("Usuario a eliminar no existe.");
        }
        else{
            usuarioDAO.remove(usuario);
        }
    }

    @Override
    public Usuario consultarxDocumento(Integer documento) throws Exception {
        if(documento == 0 || documento == null){
            throw new Exception("Campo Documento obligatorio.");
        }
        else{
            return usuarioDAO.find(documento);
        }
    }

    @Override
    public List<Usuario> consultarTodos() throws Exception {
        return usuarioDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
