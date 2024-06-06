
package test;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import sun.misc.Queue;

public class Test {
    public static void main(String[] args) {
        int cantidadEquipos = 0;
        int cantidadRondas = 0;
        Scanner ingresoTeclado = new Scanner(System.in);
        
        System.out.println("==== BIENVENIDOS AL TORNEO DE BALONCESTO ====");
        System.out.print("Ingrese la cantidad de equipos participantes (nro par) --> ");
        try{
            cantidadEquipos = ingresoTeclado.nextInt();
        }catch (Exception e){
            System.out.println("Valor mal ingresado, por favor indique un valor entero.");
            e.printStackTrace();
        }
        
        System.out.print("Ingrese la cantidad de rondas a realizar --> ");
        try{
            cantidadRondas = ingresoTeclado.nextInt();
        }catch (Exception e){
            System.out.println("Valor mal ingresado, por favor indique un valor entero.");
            e.printStackTrace();
        }
        
        ingresoTeclado.nextLine();
        LinkedList<Equipo> equipos = new LinkedList<>();
        LinkedList<Equipo> equiposAux = new LinkedList<>();
        
        for (int i = 0; i < cantidadEquipos; i++) {
            Equipo nuevoEquipo = null;
            System.out.print("Nombre del "+(i+1)+" ° equipo --> ");
            nuevoEquipo = new Equipo(ingresoTeclado.next());
            equipos.add(nuevoEquipo);
            equiposAux.add(nuevoEquipo);
        }

        ArbolTernario arbol = new ArbolTernario();
        Random aleatorio = new Random();
        int posicionResultado = 0;
        Resultado[] resultados = new Resultado[equipos.size()/2];
        
        for (int i = 0; i < cantidadRondas; i++) {
            
       // Registrar resultados de cada ronda formando enfrentamientos al azar
       
            System.out.println("==== INGRESO DE RESULTADOS DE LA "+(i+1)+"° RONDA ====");
       
            while(!equipos.isEmpty()){
                Equipo equipoA = equiposAux.remove(aleatorio.nextInt(equipos.size()));
                Equipo equipoB = equiposAux.remove(aleatorio.nextInt(equipos.size()));
                System.out.print("Ingrese puntaje del equipo "+equipoA.getNombre()+" --> ");
                int puntajeA = ingresoTeclado.nextInt();
                System.out.print("Ingrese puntaje del equipo "+equipoB.getNombre()+" --> ");
                int puntajeB = ingresoTeclado.nextInt();

                resultados[posicionResultado] = new Resultado(equipoA, equipoB, puntajeA, puntajeB, 1);
            }

            
            for (Resultado resultado : resultados) {
                arbol.registrarResultado(arbol.getRaiz(), resultado);
            }
            
            arbol.imprimirArbol(arbol.getRaiz(), 0);

        }
        
//        // Registrar resultados en la segunda ronda para la rama de segundas oportunidades
//        Resultado resultadoSegundaRonda = new Resultado(equipos[1], equipos[3], 60, 70);
//        arbol.registrarResultado(arbol.getRaiz().getSegundasOportunidades(), resultadoSegundaRonda);
//
//        // Registrar resultado en la rama de eliminación (equipo 1 perderá nuevamente)
//        Resultado resultadoEliminacion = new Resultado(equipos[1], equipos[5], 55, 60);
//        arbol.registrarResultado(arbol.getRaiz().getSegundasOportunidades().getSegundasOportunidades(), resultadoEliminacion);
//
//
//        // Imprimir el árbol después de la primera ronda
//        arbol.imprimirArbol(arbol.getRaiz(), 0);
    }
}
