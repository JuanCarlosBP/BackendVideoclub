package serviciospeliculas;

import beanpelicula.Pelicula;
import excepciones.ExcepcionEscribirFichero;
import excepciones.ExcepcionFichero;
import excepciones.ExcepcionLeerFichero;
import java.util.List;
import serviciodatos.IOpFicheros;
import serviciodatos.OpFicherosImp;

public class CatalogoImp implements ICatalogo {

    IOpFicheros datos;

    public CatalogoImp() {
        this.datos = new OpFicherosImp();
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = true;
        try {
            anexar = !(datos.listar(ARCHIVO).contains(pelicula));
        } catch (ExcepcionLeerFichero ex) {
            System.err.println("error de lectura de fichero.");
        }
        
        try {
            datos.escribir(pelicula, ARCHIVO, anexar);
        } catch (ExcepcionEscribirFichero ex) {
            System.err.println("Error al agregas la película " + pelicula);
        }
    }

    @Override
    public void verPeliculas() {
        try {
           List<Pelicula> lista = datos.listar(ARCHIVO);
           for(Pelicula pelicula : lista){
               System.out.println(pelicula.toString());
           }
        } catch (ExcepcionLeerFichero ex) {
            System.err.println("Error al mostrar el catálogo de películas.");
        }
    }

    @Override
    public void buscarPelicula(String pelicula) {
        try {
            datos.buscar(ARCHIVO, pelicula);
        } catch (ExcepcionLeerFichero ex) {
            System.err.println("Error al buscar la película");
        }
    }

    @Override
    public void iniciarCatalogo() {
        try {
           if(this.datos.existe(ARCHIVO)){
                datos.borrar(ARCHIVO);
                datos.crear(ARCHIVO);
            }
            else{
                datos.crear(ARCHIVO);
            }
        } catch (ExcepcionFichero ex) {
            System.err.println("No se pudo iniciar el catálogo.");
        }
    }

}
