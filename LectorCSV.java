/*Se importa java.util que es dónde está contenida la clase Scanner para leer el CSV.
 * 
 */

import java.io.*;
import java.util.*;
public class LectorCSV {
   private String direccion = "pokemon_data_pokeapi.csv";
   private Map<String, Pokemon> pokedex;

   public LectorCSV(int tipoMapa){
    this.pokedex = MapFactory.crearMapa(tipoMapa);
    cargarDatos();
   }

/* Tenemos la siguiente función que se encarga de validar el cómo están colocadas las habilidades en el CSV. Puesto que
* también están separadas por comas. Utiliza StringBuilder para poder modificar el String ya creado.
*/

    private List<String> parseCSVLine(String line) {
    List<String> values = new ArrayList<>();
    boolean dentroComillas = false;
    StringBuilder campo = new StringBuilder();

    for (char c : line.toCharArray()) {
        if (c == '"') {
            dentroComillas = !dentroComillas; // Cambiar estado
        } else if (c == ',' && !dentroComillas) {
            values.add(campo.toString().trim());
            campo.setLength(0); // Resetear campo
        } else {
            campo.append(c);
        }
    }
    values.add(campo.toString().trim()); // Agregar último valor
    return values;

/* Esta función se encarga de leer el archivo CSV con los datos de los pokemon, primero accede a la dirección proporcionada
 * y separa los datos cada que encuentra una coma. Luego los almacena en un map.
 */

}
private void cargarDatos() {
    try (BufferedReader br = new BufferedReader(new FileReader(direccion))) {
        String linea;
        br.readLine(); // Saltar encabezado

        while ((linea = br.readLine()) != null) {
            List<String> datos = parseCSVLine(linea);

            String nombre = datos.get(0);
            int numeroPokedex = Integer.parseInt(datos.get(1));
            String tipo1 = datos.get(2);
            String tipo2 = datos.get(3);
            String clasificacion = datos.get(4);
            float altura = Float.parseFloat(datos.get(5));
            float peso = Float.parseFloat(datos.get(6));
            List<String> habilidades = Arrays.asList(datos.get(7).split(", "));
            int generacion = Integer.parseInt(datos.get(8));
            boolean esLegendario = Boolean.parseBoolean(datos.get(9));

            Pokemon pokemon = new Pokemon(nombre, numeroPokedex, tipo1, tipo2, clasificacion, altura, peso, habilidades, generacion, esLegendario);
            pokedex.put(nombre.toLowerCase(), pokemon);
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo CSV: " + e.getMessage());
    }
}

    public Pokemon buscarPokemon(String nombre){
        return pokedex.get(nombre.toLowerCase());
    }

/* Aquí, similar a en la clase colección. Pasamos los valores del Map que contiene a los pokémon a una lista. Para así poder filtrarla
Por tipo1 y recorrerla para imprimirlos.*/

    public void TodosOrdenadoPorTipo1() {
        List<Pokemon> listaPokemonCSV = new ArrayList<>(pokedex.values());

        listaPokemonCSV.sort(Comparator.comparing(Pokemon::getTipo1));

        System.out.println("Pokémon en tu colección ordenados por Tipo 1:");
        for (Pokemon p : listaPokemonCSV) {
            System.out.println(p.getNombre() + " -> " + p.getTipo1());
        }
    }
}
