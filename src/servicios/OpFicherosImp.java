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
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String lectura = lector.readLine();
            while (lectura != null) {
                Pelicula pelicula = new Pelicula(lectura);
                lista.add(pelicula);
                lectura = lector.readLine();
            }
            lector.close();
        } catch (IOException ex) {
            throw new ExcepcionLeerFichero("Error al crear el archivo " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombre, boolean anexar) throws ExcepcionEscribirFichero {
        File archivo = new File(nombre);
        try ( PrintWriter nuevo = new PrintWriter(new FileWriter(archivo, anexar))) {
            nuevo.println(pelicula);
            nuevo.close();
        } catch (IOException ex) {
            throw new ExcepcionEscribirFichero("Error al escribir pelicula " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombre, String busca) throws ExcepcionLeerFichero {
        File archivo = new File(nombre);
        String resultado = "No se ha encontrado la película";
        try ( BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String lectura = lector.readLine();
            int indice=1;
            while (lectura != null) {
                if (busca != null && busca.equalsIgnoreCase(lectura)){
                    resultado = "Película "+busca+" encontrada en la línea "+indice;
                }else{
                    lectura = lector.readLine();
                }
            }
            lector.close();
        } catch (IOException ex) {
            throw new ExcepcionLeerFichero("Error al leer el archivo " + ex.getMessage());
        }
        return resultado;
    }
}