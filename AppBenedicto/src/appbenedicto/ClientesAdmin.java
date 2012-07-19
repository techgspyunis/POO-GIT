/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appbenedicto;

import java.util.ArrayList;

public class ClientesAdmin {
    
    private ArrayList<Clientes> clientes;
    
    public ClientesAdmin() {
        clientes = new ArrayList<Clientes>();
    }
    
       private void validarDatosIncompletos(String codigo, String nombre, String apellido_paterno,String apellido_materno, String email, double dni, double telefono)
            throws BusinessException {
        String msg = "";
        if (codigo == null || codigo.isEmpty())
            msg = "Código no puede ser vacio o nulo";
        if (nombre == null || nombre.isEmpty())
            msg += "\nNombre no pueder ser vacio o nulo";
        if (apellido_paterno == null || apellido_paterno.isEmpty())
            msg += "\nApellido paterno no pueder ser vacio o nulo";
        if (apellido_materno == null || apellido_paterno.isEmpty())
            msg += "\nApellido materno no pueder ser vacio o nulo";
        if (email == null || email.isEmpty())
            msg += "\nEmail no pueder ser vacio o nulo";
        if (! msg.isEmpty())
            throw new BusinessException(msg);
    }
       
    private void validarDuplicidad(String codigo)
            throws BusinessException {
        if (buscar(codigo) != null){
            String msg = "Código "+codigo+ " ya existe.";
            throw  new BusinessException(msg);
        }
    }
    
        public void registrarClientes(String codigo, String nombre, String apellido_paterno,String apellido_materno, String email, double dni, double telefono)
            throws BusinessException {
        // Aplicar validaciones de negocio
        validarDatosIncompletos(codigo, nombre, apellido_paterno,apellido_materno,email,dni,telefono);
        validarDuplicidad(codigo);
        // Crear un nuevo tipo de habitacion y registrarlo en la coleccion
        getClientes().add(new Clientes(codigo, nombre, apellido_paterno, apellido_materno,email,dni,telefono));
    }
        
    public Clientes buscar(String codigo) {
        // Buscar el tipo de habitacion por codigo
        for(Clientes cliente : getClientes())
            if (cliente.getCodigo().equals(codigo))
               return cliente;
        return null;
    }
    
    private void validarExistenciaCliente(String codigo)
            throws BusinessException {
        if (buscar(codigo) == null){
            String msg = "Cliente "+ codigo+ " no existe.";
            throw new BusinessException(msg);
        }
    }
    
    public void eliminar(String codigo) throws BusinessException {
        validarExistenciaCliente(codigo);
        getClientes().remove(buscar(codigo));
    }
    
        public ArrayList<Clientes> getClientes() {
        return clientes;
    }
    
    
}
