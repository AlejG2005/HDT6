// Clase pokemon que contiene todas las características del mismo
public class Pokemon {
   private String nombre;
   private String numPokedex;
   private String tipo1;
   private String tipo2;
   private String clasificacion;
   private String altura;
   private String peso;
   private String habilidades;
   private String generacion;
   private String legendario;

//Constructor del objeto pokemon
   public Pokemon(String nombre, String numPokedex, String tipo1, String tipo2, String clasificacion, String altura, String peso, String habilidades, String generacion, String legendario) {
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
   public String getNumPokedex() {
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
   public String getAltura() {
    return altura;
   }
   public String getPeso() {
    return peso;
   }
   public String getHabilidades() {
    return habilidades;
   }
   public String getGeneracion() {
    return generacion;
   }
   public String getLegendario() {
    return legendario;
   }

   @Override
    public String toString() {
        return "Nombre: " + nombre + ", Tipo 1: " + tipo1 + ", Tipo 2: " + (tipo2.isEmpty() ? "Ninguno" : tipo2 + ", Clasificación: " + clasificacion + ", Altura [cm]: " + altura + ", Peso [kg]: " + peso + ", Habilidades: " + habilidades + "; Generación: " + generacion + ", ¿Legendario? " + legendario);
    }
}