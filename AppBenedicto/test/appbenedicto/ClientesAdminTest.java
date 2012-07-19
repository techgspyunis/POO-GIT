/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appbenedicto;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClientesAdminTest {
    
    @Test
    public void adminDebeRegistrarClientes(){
        // Arrange
        String codigo = "C01";
        String nombre = "Franklin";
        String apellido_paterno = "Velita";
        String apellido_materno = "Zorrilla";
        String email = "fvelita@gmail.com";
        double dni = 15447482;
        double telefono = 15474745;
        
        ClientesAdmin admin = new ClientesAdmin();
        
        try {
            admin.registrarClientes(codigo, nombre, apellido_paterno, apellido_materno,email,dni,telefono);
        } catch (BusinessException ex) {
            Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        Clientes cliente = admin.buscar(codigo);

        assertNotNull(cliente);
        assertEquals(codigo, cliente.getCodigo());
        assertEquals(nombre, cliente.getNombre());
        assertEquals(apellido_paterno, cliente.getApellido_paterno());
        assertEquals(apellido_materno, cliente.getApellido_materno());
        assertEquals(email, cliente.getEmail());
        assertEquals(dni, cliente.getDni(), 0.0);
        assertEquals(telefono, cliente.getTelefono(), 0.0);
    }
    
    @Test(expected=BusinessException.class)
    public void adminDebeRegistrarValidandoDatosIncompletosEnClientes()
            throws BusinessException{
        String codigo = "C01";
        String nombre = "Franklin";
        String apellido_paterno = "";
        String apellido_materno = "";
        String email = "fvelita@gmail.com";
        double dni = 15447482;
        double telefono = 15474745;

        ClientesAdmin admin = new ClientesAdmin();
        admin.registrarClientes(codigo, nombre, apellido_paterno, apellido_materno,email,dni,telefono);
    }
    
    @Test(expected=BusinessException.class)
    public void adminDebeRegistrarClientesValidandoDuplicidad()
           throws BusinessException{
        
        String codigo = "C01";
        String nombre = "Franklin";
        String apellido_paterno = "Velita";
        String apellido_materno = "Zorrilla";
        String email = "fvelita@gmail.com";
        double dni = 15447482;
        double telefono = 15474745;
        
        ClientesAdmin admin = new ClientesAdmin();
        
        admin.registrarClientes(codigo, nombre, apellido_paterno, apellido_materno,email,dni,telefono);
        admin.registrarClientes(codigo, nombre, apellido_paterno, apellido_materno,email,dni,telefono);
    }
    
    
    @Test
    public void adminDebeEliminarClientePorCodigo()
           throws BusinessException{
        
        String codigo = "C01";
        String nombre = "Franklin";
        String apellido_paterno = "Velita";
        String apellido_materno = "Zorrilla";
        String email = "fvelita@gmail.com";
        double dni = 15447482;
        double telefono = 15474745;
        
        ClientesAdmin admin = new ClientesAdmin();
        admin.registrarClientes(codigo, nombre, apellido_paterno, apellido_materno,email,dni,telefono);
        // Act
        admin.eliminar(codigo);
        // Assert
        Clientes cliente = admin.buscar(codigo);
        assertNull(cliente);
    }
    
    @Test(expected=BusinessException.class)
    public void adminDebeValidarExistenciaClientesAntesDeEliminar() throws BusinessException
    {
        String codigo = "C01";
        String nombre = "Franklin";
        String apellido_paterno = "Velita";
        String apellido_materno = "Zorrilla";
        String email = "fvelita@gmail.com";
        double dni = 15447482;
        double telefono = 15474745;
        
        ClientesAdmin admin = new ClientesAdmin();
        admin.registrarClientes(codigo, nombre, apellido_paterno, apellido_materno,email,dni,telefono);
        // Act
        admin.eliminar("C02");

    }
    
}
