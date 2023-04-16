package serviciospeliculas;

import beanpelicula.Pelicula;

public interface ICatalogo {

    String ARCHIVO = "peliculas.txt";

    void agregarPelicula(Pelicula pelicula);

    void verPeliculas();

    void buscarPelicula(String pelicula);

    void iniciarCatalogo();
}
