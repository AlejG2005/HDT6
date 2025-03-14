import java.util.InputMismatchException;
import java.util.Scanner;

public class MainPokemon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el tipo de Map que quiere usar para guardar los pokémon.
        int tipoMapa = 0;
        while (true) {
            System.out.println("\n---Seleccione el tipo de estructura para almacenar los Pokémon:---");
            System.out.println("1. HashMap (Orden impredecible, rápido)");
            System.out.println("2. TreeMap (Ordenado alfabéticamente)");
            System.out.println("3. LinkedHashMap (Mantiene orden de inserción)");
            System.out.print("Ingrese su elección: ");

            try {
                tipoMapa = scanner.nextInt();
                scanner.nextLine(); 

                if (tipoMapa >= 1 && tipoMapa <= 3) {
                    break; 
                } else {
                    System.out.println("\nOpción inválida. Ingresa un número entre 1 y 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada no válida. Por favor, introduce un NÚMERO del 1 al 3.");
                scanner.nextLine(); 
            }
        }

        LectorCSV lector = new LectorCSV(tipoMapa);
        Coleccion coleccion = new Coleccion();

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar Pokémon a tu colección");
            System.out.println("2. Mostrar tu colección");
            System.out.println("3. Mostrar tu colección ordenada por tipo1");
            System.out.println("4. Buscar Pokémon por nombre (Generaciones 1-8)");
            System.out.println("5. Todos lo pokémon y su tipo1 (Generaciones 1-8)");
            System.out.println("6. Buscar pokémon por habilidad (Generaciones 1-8)");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.print("\nIngresa el nombre del Pokémon: ");
                        String nombre = scanner.nextLine();
                        Pokemon pokemon = lector.buscarPokemon(nombre);
                        if (pokemon != null) {
                            coleccion.agregarPokemon(pokemon);
                        } else {
                            System.out.println("\nError: ¡Ese Pokémon no existe en la base de datos!");
                        }
                        break;
                    case 2:
                        coleccion.mostrarColeccion();
                        break;
                    case 3:
                        coleccion.mostrarOrdenadoPorTipo1();
                        break;
                    case 4:
                        System.out.print("\nIngresa el nombre del Pokémon: ");
                        String nombreBusqueda = scanner.nextLine();
                        Pokemon pokemonBusqueda = lector.buscarPokemon(nombreBusqueda);
                        if (pokemonBusqueda != null) {
                            System.out.println(pokemonBusqueda);
                        } else {
                        System.out.println("\nError: ¡Ese Pokémon no existe en la base de datos!");
                        }
                        break;
                    case 5:
                        lector.TodosOrdenadoPorTipo1();
                        break;
                    case 6:
                        System.out.print("\nIngresa el nombre de la habilidad: ");
                        String habilidadCSV = scanner.nextLine();
                        lector.BuscarPorHabilidad(habilidadCSV);
                        break;
                    case 7:
                        System.out.println("\nSaliendo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("\nOpción inválida.");
                    }            
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada no válida. Por favor, introduce un NÚMERO del 1 al 7: ");
                scanner.nextLine();
            }
        }
    }
}
