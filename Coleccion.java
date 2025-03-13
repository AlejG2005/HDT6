//Nos permitirá utilizar estructuras del tipo Set, que nos sirven ya que no permiten datos duplicados.
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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
            System.out.println(pokemon.getNombre() + " ha sido añadido a tu colección. ¡Ve a por otro!");
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

//Método en el cuál recibimos el Map creado y lo convertimos en una lista, para así ser posible ordenarlos a gusto mediante la interfaz comparator.
    public void mostrarOrdenadoPorTipo1() {
        if (coleccion.isEmpty()) {
            System.out.println("Tu colección está vacía. ¡Ve y añade unos pokémon!");
            return;
        }

        List<Pokemon> listaPokemon = new ArrayList<>(coleccion);

        listaPokemon.sort(Comparator.comparing(Pokemon::getTipo1));

        System.out.println("Pokémon en tu colección ordenados por Tipo 1:");
        for (Pokemon p : listaPokemon) {
            System.out.println(p.getNombre() + " -> " + p.getTipo1());
        }
    }
}