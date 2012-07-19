/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appbenedicto;


public class Clientes {
    
    private String codigo;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String email;
    private double dni;
    private double telefono;

    public Clientes(String codigo, String nombre, String apellido_paterno, String apellido_materno, String email, double dni, double telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getDni() {
        return dni;
    }

    public void setDni(double dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }
    
    
    
}
