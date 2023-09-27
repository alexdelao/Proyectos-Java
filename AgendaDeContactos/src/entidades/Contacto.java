
package entidades;

public class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void editarContacto(String nuevoTelefono, String nuevoEmail) {
        this.telefono = nuevoTelefono;
        this.email = nuevoEmail;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nTeléfono: " + telefono + "\nEmail: " + email;
    } 
}
