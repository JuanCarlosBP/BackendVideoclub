package servicios;

import beanpelicula.Pelicula;
import excepciones.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OpFicherosImp implements IOpFicheros {

    @Override
    public boolean existe(String nombre) {
        File archivo = new File(nombre);
        return archivo.exists();
    }

    @Override
    public void crear(String nombre) throws ExcepcionFichero {
        File archivo = new File(nombre);
        try {
            PrintWriter nuevo = new PrintWriter(archivo);
            nuevo.close();
        } catch (FileNotFoundException ex) {
            throw new ExcepcionFichero("Error al crear el archivo " + ex.getMessage());
        }

    }

    @Override
    public void borrar(String nombre) {
        File archivo = new File(nombre);
        if (archivo.exists()) {
            archivo.delete();
        }
    }

    @Override
    public List<Pelicula> listar(String nombre) throws ExcepcionLeerFichero {
        File archivo = new File(nombre);
        List<Pelicula> lista = new ArrayList<>();
        try {
            try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                String lectura = lector.readLine();
                while (lectura != null) {
                    Pelicula pelicula = new Pelicula(lectura);
                    lista.add(pelicula);
                    lectura = lector.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            throw new ExcepcionLeerFichero("Error al crear el archivo " + ex.getMessage());
        } catch (IOException ex) {
            throw new ExcepcionLeerFichero("Error al crear el archivo " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public void escribir(String nombre) throws ExcepcionEscribirFichero {

    }

    @Override
    public String buscar(String nombre, String busca) throws ExcepcionLeerFichero {

    }

}
