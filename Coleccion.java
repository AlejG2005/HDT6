//Nos permitirá utilizar estructuras del tipo Set, que nos sirven ya que no permiten datos duplicados.
import java.util.HashSet;
import java.util.Set;

/* Se refiere a la clase que representa la colección individual de pokémons de un jugador.
Utilizamos un Set debido a que no queremos pokémons repetidos. */
public class Coleccion {
    private Set<Pokemon> coleccion;

//Se crea un objeto del tipo HashSet dónde guardaremos los pokémones del jugador.
    public Coleccion() {
        coleccion = new HashSet<>();
    }

//Método por el cuál el jugador añadirá pokémons con solo su nombre. Si este ya esta en la colección no permite añadirlo.
    public boolean agregarPokemon(Pokemon pokemon) {
        if (coleccion.contains(pokemon)) {
            System.out.println("¡Quieres añadir un pokémon que ya tienes! ¿No quieres otro? ");
            return false;
        } else {
            coleccion.add(pokemon);
            System.out.println(pokemon.getNombre() + "ha sido añadido a tu colección. ¡Ve a por otro!");
            return true;
        }
    }

//Método que recorre toda la colección diciendo los nombres de los pokémons que contiene.
    public void mostrarColeccion() {
        if (coleccion.isEmpty()) {
            System.out.println("Tu colección está vacía, ¿por qué no vas a recolectar algún pokémon?");
        } else {
            System.out.println("Aquí está tu colección de pokémons por el momento: ");
            for (Pokemon pokemon : coleccion) {
                System.out.println(pokemon);
            }
        }
    }
}