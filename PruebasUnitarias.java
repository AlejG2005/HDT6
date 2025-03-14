import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

/*Clase en la que se realiza pruebas a unos de los métodos más importantes; buscarPokemon() y agregarPokemon().*/

class PruebasUnitarias {
    private LectorCSV lector;
    private Coleccion coleccion;

    @BeforeEach
    void setUp() {
        // Inicializamos el lector y la colección antes de cada prueba
        lector = new LectorCSV(1); // HashMap
        coleccion = new Coleccion();

        // Agregamos Pokémon de prueba a la pokedex
        lector.getPokedex().put("pikachu", new Pokemon("Pikachu", 25, "Eléctrico", "", "Ratón", 0.4f, 6.0f, List.of("Electricidad Estática", "Pararrayos"), 1, false));
        lector.getPokedex().put("charmander", new Pokemon("Charmander", 4, "Fuego", "", "Lagartija", 0.6f, 8.5f, List.of("Mar Llamas"), 1, false));
    }

    /** 1️⃣ Prueba de `buscarPokemon()` */
    @Test
    void testBuscarPokemon() {
        Pokemon pikachu = lector.buscarPokemon("Pikachu");
        assertNotNull(pikachu);
        assertEquals("Pikachu", pikachu.getNombre());

        Pokemon inexistente = lector.buscarPokemon("Inexistente");
        assertNull(inexistente);
    }

    /** 2️⃣ Prueba de `agregarPokemon()` */
    @Test
    void testAgregarPokemon() {
        Pokemon charmander = lector.buscarPokemon("Charmander");

        assertTrue(coleccion.agregarPokemon(charmander)); // Se agrega la primera vez
        assertFalse(coleccion.agregarPokemon(charmander)); // No debe agregar duplicado
    }
}
