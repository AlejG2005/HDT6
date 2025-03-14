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

   public Map<String, Pokemon> getPokedex() {
    return pokedex;
}


/* Tenemos la siguiente función que se encarga de validar el cómo están colocadas las habilidades en el CSV. Puesto que
* también están separadas por comas. Utiliza StringBuilder para poder modificar el String ya creado.
*/

    private List<String> parsearCSVLine(String line) {
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
            List<String> datos = parsearCSVLine(linea);

            String nombre = datos.get(0);
            int numeroPokedex = Integer.parseInt(datos.get(1));
            String tipo1 = datos.get(2);
            String tipo2 = datos.get(3);
            String clasificacion = datos.get(4);
            float altura = Float.parseFloat(datos.get(5));
            float peso = Float.parseFloat(datos.get(6));
            List<String> habilidades = Arrays.asList(datos.get(7).split(", "));
            int generacion = Integer.parseInt(datos.get(8));
            boolean esLegendario = datos.get(9).equalsIgnoreCase("Yes"); 

            Pokemon pokemon = new Pokemon(nombre, numeroPokedex, tipo1, tipo2, clasificacion, altura, peso, habilidades, generacion, esLegendario);
            pokedex.put(nombre.toLowerCase(), pokemon);
        }
    } catch (IOException e) {
        System.out.println("\nError al leer el archivo CSV: " + e.getMessage());
    }
}

//Método que recibe como parámetro el nombre de un pokémon y lo va a buscar en la base de datos. 

    public Pokemon buscarPokemon(String nombre){
        return pokedex.get(nombre.toLowerCase());
    }

/* Aquí, similar a en la clase colección. Pasamos los valores del Map que contiene a los pokémon a una lista. Para así poder filtrarla
Por tipo1 y recorrerla para imprimirlos.*/

    public void TodosOrdenadoPorTipo1() {
        List<Pokemon> listaPokemonCSV = new ArrayList<>(pokedex.values());

        listaPokemonCSV.sort(Comparator.comparing(Pokemon::getTipo1));

        System.out.println("\nPokémon en tu colección ordenados por Tipo 1:");
        for (Pokemon p : listaPokemonCSV) {
            System.out.println("\n"+p.getNombre() + " -> " + p.getTipo1());
        }
    }

    /* Este método se encarga de recibir una habilidad escrita por usuario y compara qué pokémon la tienen recorriendo get.habilidades(). Los que coincidan los 
    guarda en una lista. luego recorre la lista de resultados e imprime todos lo pokémon contenidos en ella. */

    public void BuscarPorHabilidad(String habilidadCSV) {
        List<Pokemon> listaPokemonCSV = new ArrayList<>(pokedex.values());
        List<Pokemon> resultadoCSV = new ArrayList<>();

    for (Pokemon p : listaPokemonCSV) {
        for (String habilidad : p.getHabilidades()) {
            if (habilidad.equalsIgnoreCase(habilidadCSV)) {
                resultadoCSV.add(p);
                break;
            }
        }
    }

    if (resultadoCSV.isEmpty()) {
        System.out.println("\nNo se encontraron Pokémon con la habilidad: " + habilidadCSV);
    } else {
        System.out.println("\nPokémon con la habilidad '" + habilidadCSV + "':\n");
        for (Pokemon p : resultadoCSV) {
            System.out.println(p+"\n");
            }
        }
    }
} 
