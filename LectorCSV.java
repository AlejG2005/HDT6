/*Se importa java.util que es dónde está contenida la clase Scanner para leer el CSV.
 * 
 */

import java.io.*;
import java.util.*;
public class LectorCSV {
   private String direccion = "pokemon_data_pokeapi.csv";
   private Map<String, Pokemon> pokedex = new HashMap<>();

   public LectorCSV(){
    cargarDatos();
   }
/* Esta función se encarga de leer el archivo CSV con los datos de los pokemon, primero accede a la dirección proporcionada
 * y separa los datos cada que encuentra una coma. Luego los almacena en un map.
 */
   private void cargarDatos() {
    try (BufferedReader br = new BufferedReader(new FileReader(direccion))) {
        String linea;
        br.readLine(); 

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String nombre = datos[0];
            String numPokedex = datos[1];
            String tipo1 = datos[2];
            String tipo2 = datos[3];
            String clasificacion = datos[4];
            String altura = datos[5];
            String peso = datos[6];
            String habilidades = datos[7];
            String generacion = datos[8];
            String legendario = datos[9];


            Pokemon pokemon = new Pokemon(nombre, numPokedex, tipo1, tipo2, clasificacion, altura, peso, habilidades, generacion, legendario);
            pokedex.put(nombre.toLowerCase(), pokemon);
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo CSV. Intente de nuevo." + e.getMessage());
    }
}
    public Pokemon buscarPokemon(String nombre){
        return pokedex.get(nombre.toLowerCase());
    }
}
