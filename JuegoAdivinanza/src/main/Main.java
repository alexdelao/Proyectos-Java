package main;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean jugarDeNuevo = true;

        while (jugarDeNuevo) {
            int numeroAleatorio = random.nextInt(100) + 1; // Generar un número aleatorio entre 1 y 100
            int intentosMaximos = 10;
            int intentos = 0;
            int puntos = 100;

            System.out.println("¡Bienvenido al juego de adivinanza!");
            System.out.println("Adivina el número entre 1 y 100.");

            while (intentos < intentosMaximos) {
                System.out.print("Intento #" + (intentos + 1) + " - Ingresa tu suposición: ");
                int suposicion = scanner.nextInt();
                intentos++;

                if (suposicion < numeroAleatorio) {
                    System.out.println("El número es mayor.");
                    puntos -= 10; // Penalizar por suposición incorrecta
                } else if (suposicion > numeroAleatorio) {
                    System.out.println("El número es menor.");
                    puntos -= 10; // Penalizar por suposición incorrecta
                } else {
                    System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
                    System.out.println("Puntuación final: " + puntos + " puntos");
                    break;
                }

                if (intentos == intentosMaximos) {
                    System.out.println("Agotaste tus intentos. El número era " + numeroAleatorio + ".");
                    System.out.println("Puntuación final: " + puntos + " puntos");
                }
            }

            System.out.print("¿Quieres jugar de nuevo? (S/N): ");
            String respuesta = scanner.next();
            if (!respuesta.equalsIgnoreCase("S")) {
                jugarDeNuevo = false;
            }
        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }
}
