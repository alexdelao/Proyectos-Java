package agendadecontactos;

import entidades.Agenda;
import entidades.Contacto;
import java.util.Scanner;

public class AgendaDeContactos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        while (true) {
            System.out.println("\n*** Agenda de Contactos ***");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Editar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            //int opcion = scanner.nextInt();
            //scanner.nextLine(); // Consumir la nueva línea
            
            String entrada = scanner.nextLine();

            if (!esNumero(entrada)) {
                System.out.println("Entrada no válida. Por favor, seleccione una opción válida.");
                continue;
            }

            int opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    agenda.agregarContacto(nombre, telefono, email);
                    System.out.println("Contacto agregado.");
                    break;
                case 2:
                    agenda.listarContactos();
                    break;
                case 3:
                    System.out.print("Nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Contacto contactoBuscado = agenda.buscarContacto(nombreBuscar);
                    if (contactoBuscado != null) {
                        System.out.println("Contacto encontrado:\n" + contactoBuscado);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nombre a editar: ");
                    String nombreEditar = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    System.out.print("Nuevo email: ");
                    String nuevoEmail = scanner.nextLine();
                    agenda.editarContacto(nombreEditar, nuevoTelefono, nuevoEmail);
                    break;
                case 5:
                    System.out.print("Nombre a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    agenda.eliminarContacto(nombreEliminar);
                    break;
                case 6:
                    System.out.println("Saliendo de la agenda.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
        
    }
     private static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
