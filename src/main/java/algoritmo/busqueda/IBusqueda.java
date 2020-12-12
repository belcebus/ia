package algoritmo.busqueda;

import utilidades.Solucion;
import utilidades.exploradores.IExplorador;

public interface IBusqueda {

    public static final String INFORMADA = "informada";
    public static final String NO_INFORMADA = "noinformada";

    public Solucion run(String datosIniciales, String solucionFinal, IExplorador explorador);

}
