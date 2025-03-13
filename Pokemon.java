import java.util.*;
// Clase pokemon que contiene todas las características del mismo
public class Pokemon {
   private String nombre;
   private int numPokedex;
   private String tipo1;
   private String tipo2;
   private String clasificacion;
   private float altura;
   private float peso;
   private List<String> habilidades;
   private int generacion;
   private boolean legendario;

//Constructor del objeto pokemon
   public Pokemon(String nombre, int numPokedex, String tipo1, String tipo2, String clasificacion, float altura, float peso, List<String> habilidades, int generacion, boolean legendario) {
    this.nombre = nombre;
    this.numPokedex = numPokedex;
    this.tipo1 = tipo1;
    this.tipo2 = tipo2;
    this.clasificacion = clasificacion;
    this.altura = altura;
    this.peso = peso;
    this.habilidades = habilidades;
    this.generacion = generacion;
    this.legendario = legendario;
   }

//Getters
   public String getNombre() {
    return nombre;
   }
   public int getNumPokedex() {
    return numPokedex;
   }
   public String getTipo1() {
    return tipo1;
   }
   public String getTipo2() {
    return tipo2;
   }
   public String getClasificacion() {
    return clasificacion;
   }
   public float getAltura() {
    return altura;
   }
   public float getPeso() {
    return peso;
   }
   public List<String> getHabilidades() {
    return habilidades;
   }
   public int getGeneracion() {
    return generacion;
   }
   public boolean getLegendario() {
    return legendario;
   }

   @Override
    public String toString() {
        return "Nombre: " + nombre + ", Número en la Pokedex: " + numPokedex + ", Tipo 1: " + tipo1 + ", Tipo 2: " + (tipo2.isEmpty() ? "Ninguno" : tipo2) + ", Clasificación: " + clasificacion + ", Altura [m]: " + altura + ", Peso [kg]: " + peso + ", Habilidades: " + habilidades + ", Generación: " + generacion + ", ¿Legendario? " + legendario;
    }
}