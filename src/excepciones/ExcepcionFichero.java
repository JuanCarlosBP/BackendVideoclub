package excepciones;

public class ExcepcionFichero extends Exception {

    private static final long serialVersionUID = 1L;

    public ExcepcionFichero(String mensaje) {
        super(mensaje);
    }
}
