
package test;

public class Test {
    public static void main(String[] args) {
        Equipo[] equipos = new Equipo[8];
        for (int i = 0; i < 8; i++) {
            equipos[i] = new Equipo("Equipo " + (i + 1));
        }

        ArbolTernario arbol = new ArbolTernario();

        // Registrar resultados de la primera ronda
        Resultado[] resultados = {
            new Resultado(equipos[0], equipos[1], 70, 65),
            new Resultado(equipos[2], equipos[3], 80, 75),
            new Resultado(equipos[4], equipos[5], 90, 85),
            new Resultado(equipos[6], equipos[7], 100, 95)
        };

        for (Resultado resultado : resultados) {
            arbol.registrarResultado(arbol.getRaiz(), resultado);
        }
        
        // Registrar resultados en la segunda ronda para la rama de segundas oportunidades
        Resultado resultadoSegundaRonda = new Resultado(equipos[1], equipos[3], 60, 70);
        arbol.registrarResultado(arbol.getRaiz().getSegundasOportunidades(), resultadoSegundaRonda);

        // Registrar resultado en la rama de eliminación (equipo 1 perderá nuevamente)
        Resultado resultadoEliminacion = new Resultado(equipos[1], equipos[5], 55, 60);
        arbol.registrarResultado(arbol.getRaiz().getSegundasOportunidades().getSegundasOportunidades(), resultadoEliminacion);


        // Imprimir el árbol después de la primera ronda
        arbol.imprimirArbol(arbol.getRaiz(), 0);
    }
}
