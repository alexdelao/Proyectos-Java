
package entidades;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();
    }

    public void agregarContacto(String nombre, String telefono, String email) {
        Contacto nuevoContacto = new Contacto(nombre, telefono, email);
        contactos.add(nuevoContacto);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contacto contacto : contactos) {
                System.out.println(contacto);
                System.out.println("----------------------");
            }
        }
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public void editarContacto(String nombre, String nuevoTelefono, String nuevoEmail) {
        Contacto contacto = buscarContacto(nombre);
        if (contacto != null) {
            contacto.editarContacto(nuevoTelefono, nuevoEmail);
            System.out.println("Contacto editado correctamente.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void eliminarContacto(String nombre) {
        Contacto contacto = buscarContacto(nombre);
        if (contacto != null) {
            contactos.remove(contacto);
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }
}
