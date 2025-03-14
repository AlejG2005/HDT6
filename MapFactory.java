import java.util.*;

public class MapFactory {
    public static Map<String, Pokemon> crearMapa(int opcion) {
        switch (opcion) {
         
            case 1:
            System.out.println("\nHashMap:");
            return new HashMap<>();

            case 2:
            System.out.println("\nTreeMap:");
            return new TreeMap<>();

            case 3:
            System.out.println("\nLinkedHashMap:");
            return new LinkedHashMap<>();

            default:
            System.out.println("\nError, esa opción no está disponible. Se usará un HashMap por default.");
            return new HashMap<>();
                    
            }
        }
    }
