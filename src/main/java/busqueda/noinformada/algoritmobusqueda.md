## Búsqueda no informada

### En amplitud

Se plantea un árbol en el que cada nodo es una posible solución fruto de aplicar
la __función de exploración__ sobre dicho nodo. En el caso del problema del puzzle
lineal, esta función consiste en intercambiar las piezas adyacentes
entre sí. En el caso del problema de conexión de los vuelos, el algoritmo de
exploración retornará todos aquellos aeropuertos con conexión desde el aeropuerto
en el que nos encontremos. La búsqueda en amplitud tiene una __complejidad temporal__
de tipo _O(b^d)_, donde _b_ es el factor de ramificación (nodos retornados por la
función de exploración) y _d_ es el nivel en el árbol donde se encuentra la solcuión.
En cuanto a la complejidad espacial (uso de memoria), el algoritmo mantiene en
memoria una lista con los nodos explorados por lo que hablamos tambiñén de _O(b^d)_
que disminuye hasta _O(b^(d-1))_ para los nodos visitados. Para determinar, de entre
todos los nodos que forman la frontera, el siguiente nodo en explorar, se utiliza
una cola FIFO, que es lo que hace que se recorran todos los nodos de un mismo
nivel antes de descender al siguiente.

Se trata de un algoritmo __completo__, es decir, siempre acabará encontrando una
solución, otra cosa es cuánto tiempo hará tal cosa.
Una solución se dice _óptima_ si no se encuentra una solución mejor.
En el caso del problema de solución del puzzle lineal, una solución es óptima
si es la solución con el menor número de movimientos posibles. En el caso de las
conexiones de vuelos, una solución es óptima si no existe otra solución con un
número menor de conexiones.

* Problema de puzzle lineal
* Problema de conexión de vuelos

### En profundidad

Genera un árbol como el de búsqueda en amplitud pero se recorre de manera diferente.
La función que selecciona, de entre todos los nodos de la frontera que genera la
función de exploración, se elige el que fuera añadido en último lugar. Esto quiere
decir que se trata de una cola LIFO. Esta forma de almacenar los nodos frontera para
su exploración, hace que se recorran los nodos hasta el nivel más profundo en primer
lugar para después continuar con el siguiente nivel. Esto hace que exista la
posibilidad de que no se salga nunca de la primera rama si no se controla la
profundidad a recorrer.

La __complejidad temporal__ para es tipo de algoritmos _O(b^p)_ siendo p la profundidad.
La __complejidad espacial__ es menor que la complejidad necesaria por el algoritmo en
amplitud ya que se puede tratar el árbol obviando la lista de nodos visitados (podría
darse el caso de bucles infinitos).
Esta lista es solamente útil cuando estamos tratando grafos y no árboles.
Entonces, no es necesario almacenar los nodos visitados y cuando exploramos
una rama, los nodos no son añadidos a la lista de nodos frontera y no es
necesario mantener una lista tan grande como con el algoritmo en anchura.
Entonces hablamos de una complejidad espacial _O(bm)_.

* Problema de puzzle lineal
* Problema de conexión de vuelos

#### En profundidad mejorada (limitada)

Si no se fija el número de niveles que podemos explorar y la solución no se
encuentra en esta primera rama, es posible que la búsqueda en profundidad no
termine jamás. Para ello se puede limitar esta profundidad.

#### En profundidad mejorada (iterativa)

Para convertir el algoritmo de búsqueda no informada en óptimo, podemos partir de
la limitación de niveles anterior pero incrementando el nivel por cada ejecución.

### Búsqueda de coste uniforme

El algoritmo de búsqueda no informada con coste uniforme, realiza una exploración 
del árbol de soluciones mediante la extracción de los nodos de la frontera 
como una cola con prioridades, en la que cada vez se va extrayendo el nodo con 
menor coste. El coste debe ir actualizándose en la lista de nodos frontera.