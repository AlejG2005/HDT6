import java.util.*;

public class MapFactory {
    public static Map<String, Pokemon> crearMapa(int opcion) {
        switch (opcion) {

            case 1:
            System.out.println("HashMap:");
            return new HashMap<>();

            case 2:
            System.out.println("TreeMap:");
            return new TreeMap<>();

            case 3:
            System.out.println("LinkedHashMap:");
            return new LinkedHashMap<>();

            default:
            System.out.println("Error, esa opción no está disponible. Se usará un HashMap por default.");
            return new HashMap<>();
        }
    }
}
