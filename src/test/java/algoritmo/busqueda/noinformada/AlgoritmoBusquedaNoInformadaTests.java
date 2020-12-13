package algoritmo.busqueda.noinformada;

import org.junit.Assert;
import org.junit.Test;
import utilidades.Coordenada;
import utilidades.Solucion;
import utilidades.exploradores.ExploradorLineal;
import utilidades.exploradores.FactoriaExploradores;
import utilidades.exploradores.IExplorador;

import java.util.LinkedList;

public class AlgoritmoBusquedaNoInformadaTests {

    @Test
    public void linealAmplitud(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();

        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "321",
                "123",
                new ExploradorLineal(IExplorador.AMPLITUD));

        Assert.assertEquals("321 231 213 123",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(6,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(10,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
    }

    @Test
    public void linealAmplitudConFactoria1(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.PUZZLE_LINEAL,IExplorador.AMPLITUD,"0");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "321",
                "123",
                factoria.crearExplorador());

        Assert.assertEquals("321 231 213 123",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(6,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(10,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
    }

    @Test
    public void linealAmplitudConFactoria2(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.PUZZLE_LINEAL,IExplorador.AMPLITUD);
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "321",
                "123",
                factoria.crearExplorador());

        Assert.assertEquals("321 231 213 123",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(6,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(10,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
    }
    @Test
    public void linealAmplitudConFactoria3(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.PUZZLE_LINEAL,IExplorador.AMPLITUD,"100");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "321",
                "123",
                factoria.crearExplorador());

        Assert.assertEquals("321 231 213 123",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(6,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(10,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
    }

    @Test
    public void linealProfundidad(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();

        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "321",
                "123",
                new ExploradorLineal(IExplorador.PROFUNDIDAD));

        Assert.assertEquals("321 312 132 123",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(4,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(6,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
    }

    @Test
    public void linealProfundidadConFactoria1(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.PUZZLE_LINEAL,IExplorador.PROFUNDIDAD);
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "321",
                "123",
                factoria.crearExplorador());

        Assert.assertEquals("321 312 132 123",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(4,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(6,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
    }
    @Test
    public void linealProfundidadConFactoria2(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.PUZZLE_LINEAL,IExplorador.PROFUNDIDAD,"0");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "321",
                "123",
                factoria.crearExplorador());

        Assert.assertEquals("321 312 132 123",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(4,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(6,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
    }
    @Test
    public void linealProfundidadConFactoria3(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.PUZZLE_LINEAL,IExplorador.PROFUNDIDAD,"100");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "321",
                "123",
                factoria.crearExplorador());

        Assert.assertEquals("321 312 132 123",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(4,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(6,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
    }

    @Test
    public void linealProfundidadLimitada1(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.PUZZLE_LINEAL,IExplorador.PROFUNDIDAD_LIMITADA,"100");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "321",
                "123",
                factoria.crearExplorador());

        Assert.assertEquals("321 312 132 123",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(4,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(6,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
    }

    @Test
    public void linealProfundidadLimitada2(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.PUZZLE_LINEAL,IExplorador.PROFUNDIDAD_LIMITADA,"100");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "4321",
                "1234",
                factoria.crearExplorador());

        Assert.assertEquals("4321 4312 4132 4123 4213 4231 2431 2413 2143 2134 2314 2341 3241 3214 3124 3142 1342 1324 1234",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(21,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(60,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(18,solucionPuzzle.getProfundidad());
    }

    @Test
    public void linealProfundidadLimitada3(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.PUZZLE_LINEAL,IExplorador.PROFUNDIDAD_LIMITADA,"10");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "4321",
                "1234",
                factoria.crearExplorador());

        Assert.assertEquals("4321 4312 4132 4123 4213 4231 2431 2413 2143 2134 1234",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(12,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(33,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(10,solucionPuzzle.getProfundidad());
    }

    @Test
    public void conexionesAmplitudConFactoria1(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.CONEXIONES,IExplorador.AMPLITUD);
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA BARCELONA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(8,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(20,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(2,solucionPuzzle.getProfundidad());
    }
    @Test
    public void conexionesAmplitudConFactoria2(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.CONEXIONES,IExplorador.AMPLITUD,"0");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA BARCELONA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(8,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(20,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(2,solucionPuzzle.getProfundidad());
    }

    @Test
    public void conexionesAmplitudConFactoria3(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.CONEXIONES,IExplorador.AMPLITUD,"100");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA BARCELONA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(8,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(20,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(2,solucionPuzzle.getProfundidad());
    }

    @Test
    public void conexionesProfundidadConFactoria1(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.CONEXIONES,IExplorador.PROFUNDIDAD);
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA BARCELONA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(4,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(9,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(2,solucionPuzzle.getProfundidad());
    }
    @Test
    public void conexionesProfundidadConFactoria2(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.CONEXIONES,IExplorador.PROFUNDIDAD,"0");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA BARCELONA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(4,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(9,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(2,solucionPuzzle.getProfundidad());
    }
    @Test
    public void conexionesProfundidadConFactoria3(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.CONEXIONES,IExplorador.PROFUNDIDAD,"100");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA BARCELONA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(4,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(9,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(2,solucionPuzzle.getProfundidad());
    }

    @Test
    public void conexionesProfundidadLimitadaConFactoria1(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.CONEXIONES,IExplorador.PROFUNDIDAD_LIMITADA,"100");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA BARCELONA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(4,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(9,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(2,solucionPuzzle.getProfundidad());
    }
    @Test
    public void conexionesProfundidadLimitadaConFactoria2(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.CONEXIONES,IExplorador.PROFUNDIDAD_LIMITADA,"1");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(4,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(15,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(-1,solucionPuzzle.getProfundidad());
    }

    @Test
    public void viajanteAmplitudConFactoria1(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.AMPLITUD);
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA MADRID SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(6,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(19,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(2,solucionPuzzle.getProfundidad());
        Assert.assertEquals(1112,solucionPuzzle.getCoste());

    }

    @Test
    public void viajanteAmplitudConFactoria2(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.AMPLITUD, "0");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA MADRID SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(6,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(19,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(2,solucionPuzzle.getProfundidad());
        Assert.assertEquals(1112,solucionPuzzle.getCoste());

    }

    @Test
    public void viajanteAmplitudConFactoria3(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.AMPLITUD, "100");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA MADRID SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(6,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(19,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(2,solucionPuzzle.getProfundidad());
        Assert.assertEquals(1112,solucionPuzzle.getCoste());

    }

    @Test
    public void viajanteProfundidadConFactoria1(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.PROFUNDIDAD);
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA GRANADA VALENCIA BARCELONA MADRID SALAMANCA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(8,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(23,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(6,solucionPuzzle.getProfundidad());
        Assert.assertEquals(2158,solucionPuzzle.getCoste());

    }

    @Test
    public void viajanteProfundidadConFactoria2(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.PROFUNDIDAD, "0");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA GRANADA VALENCIA BARCELONA MADRID SALAMANCA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(8,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(23,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(6,solucionPuzzle.getProfundidad());
        Assert.assertEquals(2158,solucionPuzzle.getCoste());

    }

    @Test
    public void viajanteProfundidadConFactoria3(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.PROFUNDIDAD, "100");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA GRANADA VALENCIA BARCELONA MADRID SALAMANCA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(8,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(23,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(6,solucionPuzzle.getProfundidad());
        Assert.assertEquals(2158,solucionPuzzle.getCoste());

    }

    @Test
    public void viajanteProfundidadLimitadaConFactoria1(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.PROFUNDIDAD_LIMITADA, "100");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA GRANADA VALENCIA BARCELONA MADRID SALAMANCA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(8,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(23,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(6,solucionPuzzle.getProfundidad());
        Assert.assertEquals(2158,solucionPuzzle.getCoste());

    }

    @Test
    public void viajanteProfundidadLimitadaConFactoria2(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.PROFUNDIDAD_LIMITADA, "1");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(3,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(13,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(-1,solucionPuzzle.getProfundidad());
    }

    @Test
    public void viajanteProfundidadLimitadaConFactoria3(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.PROFUNDIDAD_LIMITADA, "2");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(4,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(17,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(-1,solucionPuzzle.getProfundidad());
    }

    @Test
    public void viajanteProfundidadLimitadaConFactoria4(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.PROFUNDIDAD_LIMITADA, "6");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA GRANADA VALENCIA BARCELONA MADRID SALAMANCA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(8,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(23,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(6,solucionPuzzle.getProfundidad());
        Assert.assertEquals(2158,solucionPuzzle.getCoste());
    }

    @Test
    public void viajanteCosteUniformeConFactoria1(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.COSTE_UNIFORME);
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA MADRID SALAMANCA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(10,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(29,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
        Assert.assertEquals(1106,solucionPuzzle.getCoste());
    }

    @Test
    public void viajanteCosteUniformeConFactoria2(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.COSTE_UNIFORME,"0");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA MADRID SALAMANCA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(10,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(29,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
        Assert.assertEquals(1106,solucionPuzzle.getCoste());
    }

    @Test
    public void viajanteCosteUniformeConFactoria3(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.VIAJANTE,IExplorador.COSTE_UNIFORME,"100");
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                "MALAGA",
                "SANTIAGO",
                factoria.crearExplorador());

        Assert.assertEquals("MALAGA MADRID SALAMANCA SANTIAGO",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(10,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(29,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(3,solucionPuzzle.getProfundidad());
        Assert.assertEquals(1106,solucionPuzzle.getCoste());
    }

    @Test
    public void busquedaRescateAmplitud(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.BUSQUEDA_Y_RESCATE,IExplorador.AMPLITUD);
        Coordenada inicio = new Coordenada(4,5);
        Coordenada solucion =  new Coordenada(6,7);
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                inicio,
                solucion,
                factoria.crearExplorador());

        Assert.assertEquals("(4,5) (4,6) (4,7) (5,7) (6,7)",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(29,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(112,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(4,solucionPuzzle.getProfundidad());
    }

    @Test
    public void busquedaRescateProfundidadLimitada(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.BUSQUEDA_Y_RESCATE,IExplorador.PROFUNDIDAD_LIMITADA,"4");
        Coordenada inicio = new Coordenada(4,5);
        Coordenada solucion =  new Coordenada(6,7);
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                inicio,
                solucion,
                factoria.crearExplorador());

        Assert.assertEquals("(4,5) (5,5) (6,5) (6,6) (6,7)",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(25,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(96,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(4,solucionPuzzle.getProfundidad());
    }

    @Test
    public void busquedaRescateListaCoordenadasProfundidadLimitada1(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.BUSQUEDA_Y_RESCATE,IExplorador.PROFUNDIDAD_LIMITADA,"4");
        Coordenada inicio = new Coordenada(4,5);
        Coordenada solucion1 =  new Coordenada(6,7);
        Coordenada solucion2 = new Coordenada(10,10);
        LinkedList<Coordenada> coordenadas = new LinkedList<>();
        coordenadas.add(solucion1);
        coordenadas.add(solucion2);
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                inicio,
                coordenadas,
                factoria.crearExplorador());

        Assert.assertEquals("(4,5) (5,5) (6,5) (6,6) (6,7)",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(25,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(96,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(4,solucionPuzzle.getProfundidad());
    }

    @Test
    public void busquedaRescateListaCoordenadasProfundidadLimitada2(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.BUSQUEDA_Y_RESCATE,IExplorador.PROFUNDIDAD_LIMITADA,"4");
        Coordenada inicio = new Coordenada(4,5);
        Coordenada solucion1 =  new Coordenada(6,7);
        LinkedList<Coordenada> coordenadas = new LinkedList<>();
        coordenadas.add(solucion1);
        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                inicio,
                coordenadas,
                factoria.crearExplorador());

        Assert.assertEquals("(4,5) (5,5) (6,5) (6,6) (6,7)",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(25,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(96,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(4,solucionPuzzle.getProfundidad());
    }
    @Test
    public void busquedaRescateListaCoordenadasProfundidadLimitada3(){
        AlgoritmoBusquedaNoInformada algoritmoBusquedaNoInformada = new AlgoritmoBusquedaNoInformada();
        FactoriaExploradores factoria = new FactoriaExploradores(IProblema.BUSQUEDA_Y_RESCATE,IExplorador.PROFUNDIDAD_LIMITADA,"4");
        Coordenada inicio = new Coordenada(4,5);
        Coordenada solucion1 =  new Coordenada(6,7);
        Coordenada solucion2 =  new Coordenada(10,10);
        Coordenada solucion3 =  new Coordenada(5,5);

        LinkedList<Coordenada> coordenadas = new LinkedList<>();
        coordenadas.add(solucion1);
        coordenadas.add(solucion2);
        coordenadas.add(solucion3);

        Solucion solucionPuzzle = algoritmoBusquedaNoInformada.run(
                inicio,
                coordenadas,
                factoria.crearExplorador());

        Assert.assertEquals("(4,5) (5,5)",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(14,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(52,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(1,solucionPuzzle.getProfundidad());
    }

}
