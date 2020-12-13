# ia

![Java CI with Maven](https://github.com/belcebus/ia/workflows/Java%20CI%20with%20Maven/badge.svg?branch=main)

Algoritmos para la asignatura de IA

## Construcción del proyecto

    git clone https://github.com/belcebus/ia.git
    cd ia
    mvn clean verify
    
    usage: java -jar target/algoritmos-1.0-SNAPSHOT.one-jar.jar [-a <arg>] [-i <arg>] [-l <arg>]
    [-p <arg>] [-s <arg>] [-t <arg>] [-v <arg>]
    opciones:
    -a,--algoritmo <arg>   Tipo de algoritmo a utilizar. [busqueda]
    -i,--inicio <arg>      Datos iniciales. Dependiente del problema
    -l,--limite <arg>      limite de niveles en caso de una variación con
    limite de profundidad
    -p,--problema <arg>    Tipo de problema a solucionar con el algoritmo
    seleccionada [puzzle | conexiones | viajante]
    -s,--solucion <arg>    Solución buscada. Dependiente del problema
    -t,--tipo <arg>        Tipo de algoritmo. [noinformada]
    -v,--variacion <arg>   Variación del algoritmo. [amplitud | profundidad |
    profundidadlimitada | costeunitario
    ejemplo: java -jar algoritmo.jar --algoritmo busqueda --tipo noinformada
    --variacion amplitud --problema lineal --inicio 4321 --solucion 1234


## Búsqueda no informada

[Detalles](src/main/java/algoritmo/busqueda/noinformada/algoritmobusqueda.md)

Problemas que se pueden resolver:
* En amplitud
    * Problema de puzzle lineal
    * Problema de conexión de vuelos
    * Problema del viajante de comercio (Travel Salesman Problem)
    * Búsqueda coordenadas mediante exploración cardinal
* En profundidad
    * Problema de puzzle lineal
    * Problema de conexión de vuelos
    * Problema del viajante de comercio (Travel Salesman Problem)
    * Búsqueda coordenadas mediante exploración cardinal (puede no tener solución)
* En profundidad mejorada (limitada)
    * Problema de puzzle lineal
    * Problema de conexión de vuelos
    * Problema del viajante de comercio (Travel Salesman Problem)
    * Búsqueda coordenadas mediante exploración cardinal 
* Búsqueda de coste uniforme
    * Problema del viajante de comercio (Travel Salesman Problem)
  
### Comandos

#### Puzzle lineal

##### En amplitud

    java -jar target/algoritmos-1.0-SNAPSHOT.one-jar.jar \
    --algoritmo busqueda \
    --tipo noinformada \
    --variacion amplitud \
    --problema lineal \
    --inicio 4321 \
    --solucion 1234

##### En profundidad

    java -jar target/algoritmos-1.0-SNAPSHOT.one-jar.jar \
    --algoritmo busqueda \
    --tipo noinformada \
    --variacion profundidad \        
    --problema lineal \
    --inicio 4321 \
    --solucion 1234

#### Conexiones de vuelos


#### Viajante de comercio


#### Búsqueda de coordenadas


##### En amplitud

    java -jar target/algoritmos-1.0-SNAPSHOT.one-jar.jar \
    --algoritmo busqueda \
    --tipo noinformada \
    --variacion amplitud \
    --problema busquedayrescate \
    --inicio "(4,5)" \
    --solucion "(6,7)" 

##### En profundidad

    java -jar target/algoritmos-1.0-SNAPSHOT.one-jar.jar \
    --algoritmo busqueda \
    --tipo noinformada \
    --variacion amplitud \
    --problema busquedayrescate \
    --inicio "(4,5)" \
    --solucion "(6,7)"  

##### En profundidad con limitación

    java -jar target/algoritmos-1.0-SNAPSHOT.one-jar.jar \
    --algoritmo busqueda \
    --tipo noinformada \
    --variacion profundidadlimitada \
    --problema busquedayrescate \
    --inicio "(4,5)" \
    --solucion "(6,7)" \
    --limite 10000

## Búsqueda informada
