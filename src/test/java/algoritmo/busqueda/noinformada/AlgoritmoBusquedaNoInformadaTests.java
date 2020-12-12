package algoritmo.busqueda.noinformada;

import org.junit.Assert;
import org.junit.Test;
import utilidades.Solucion;
import utilidades.exploradores.ExploradorLineal;
import utilidades.exploradores.FactoriaExploradores;
import utilidades.exploradores.IExplorador;

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

        Assert.assertEquals("",solucionPuzzle.getCamino().trim());
        Assert.assertEquals(11,solucionPuzzle.getNodosVisitados());
        Assert.assertEquals(33,solucionPuzzle.getNodosExplorados());
        Assert.assertEquals(-1,solucionPuzzle.getProfundidad());
    }


}
