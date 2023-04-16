package videoclub;

import beanpelicula.Pelicula;
import serviciospeliculas.CatalogoImp;
import serviciospeliculas.ICatalogo;

public class Videoclub {

    public static void main(String[] args) {
        String nombre="hola";
        ICatalogo cartelera=new CatalogoImp();
        cartelera.iniciarCatalogo();
        cartelera.agregarPelicula(nuevaPelicula(nombre)); 
        cartelera.verPeliculas();
        
    }
    

    private static Pelicula nuevaPelicula(String nombre) {
        Pelicula pelicula= new Pelicula(nombre);
        return pelicula;
    }
    
}
