/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appbenedicto;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Techgspyunis
 */
public class ClientesTest {
    
    public ClientesTest() {
    }

    @Test
    public void clienteDebeCrearseConTodosLosDatos(){
        
        String codigo="001";
        String nombre="Franklin";
        String apellido_paterno="Velita";
        String apellido_materno="Zorrilla";
        String email="fvelita@gmail.com";
        double dni=1544547482;
        double telefono=15755174;

        Clientes cliente = new Clientes(codigo, nombre, apellido_paterno, apellido_materno,email,dni,telefono);
        // Assert
        // Comprobar el resultado
        assertNotNull(cliente);
        assertEquals(codigo, cliente.getCodigo());
        assertEquals(nombre, cliente.getNombre());
        assertEquals(apellido_paterno, cliente.getApellido_paterno());
        assertEquals(apellido_materno, cliente.getApellido_materno());
        assertEquals(email, cliente.getEmail());
        assertEquals(dni, cliente.getDni(), 0.0);
        assertEquals(telefono, cliente.getTelefono(), 0.0);
    }
}
