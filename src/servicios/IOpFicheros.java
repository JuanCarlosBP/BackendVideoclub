package servicios;

import beanpelicula.Pelicula;
import excepciones.*;
import java.util.List;

public interface IOpFicheros {
    
    public boolean existe(String nombre);
    public void crear(String nombre) throws ExcepcionFichero;
    public void borrar(String nombre);
    public List<Pelicula> listar(String nombre) throws ExcepcionLeerFichero;
    public void escribir(Pelicula pelicula, String nombre, boolean anexar) throws ExcepcionEscribirFichero;
    public String buscar(String nombre, String busca) throws ExcepcionLeerFichero;
}
