package algoritmo.busqueda;

import utilidades.Solucion;
import utilidades.exploradores.IExplorador;

public interface IBusqueda {

    String INFORMADA = "informada";
    String NO_INFORMADA = "noinformada";

    Solucion run(Object datosIniciales, Object solucionFinal, IExplorador explorador);

}
