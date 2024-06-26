package test;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Test {

    private static Random aleatorio = new Random();
    private static ArbolRondas[] arbolesRondas;
    private static LinkedList<Resultado> resultados = new LinkedList<>();
    private static Scanner ingresoTeclado = new Scanner(System.in);
    private static ArbolRondas arbolRonda;
    private static LinkedList<Equipo> equiposGanadores = new LinkedList<>();
    private static LinkedList<Equipo> equiposSegundos = new LinkedList<>();

    public static void main(String[] args) {

        int cantidadEquipos = 0;
        int cantidadRondas = 0;
        boolean ingresoOK = false;
        LinkedList<Equipo> equipos = new LinkedList<>();

        System.out.println("==== BIENVENIDOS AL TORNEO DE BALONCESTO ====");

        while (!ingresoOK) {
            System.out.print("Ingrese la cantidad de equipos participantes (4,8,16,32) --> ");
            try {
                cantidadEquipos = ingresoTeclado.nextInt();
                if (cantidadEquipos == 4 || cantidadEquipos == 8
                        || cantidadEquipos == 16 || cantidadEquipos == 32) {
                    ingresoOK = true;
                } else {
                    System.out.println("El valor ingresado no esta permitido");
                    ingresoOK = false;
                }
            } catch (Exception e) {
                System.out.println("Valor mal ingresado, por favor indique un valor entero.");
                ingresoOK = false;
                ingresoTeclado.nextLine();
            }
        }

        ingresoTeclado.nextLine();
        cantidadRondas = (int) Math.round(Math.sqrt(cantidadEquipos)) / 2 + 2;
        arbolesRondas = new ArbolRondas[cantidadRondas];

        for (int i = 0; i < cantidadEquipos; i++) {
            Equipo nuevoEquipo = null;
            System.out.print("Nombre del " + (i + 1) + " ° equipo --> ");
            nuevoEquipo = new Equipo(ingresoTeclado.next());
            equipos.add(nuevoEquipo);
        }

        for (int i = 0; i < cantidadRondas; i++) {

            // Registrar resultados de cada ronda formando enfrentamientos al azar
            if (i == 0) {
                //PRIMERA RONDA                
                jugarRonda(i, equipos, equiposSegundos);

            } else {// A PARTIR DE AHORA JUEGAN AMBAS RAMAS, GANADORES Y SEGUNDOS. LOS PERDEDORES SE VAN MOVIENDO DE RAMAS A SEGUNDOS O ELIMINADOS

                // ENFRENTAMIENTOS DENTRO DE LA RAMA SEGUNDOS y GANADORES
                jugarRonda(i, equiposSegundos, equiposGanadores);
                // ENFRENTAMIENTOS DENTRO DE LA RAMA GANADORES

            }
        }

        //RONDA DE RECUPERACION (SOLO PARTICIPAN QUIENES ESTAN EN SEGUNDA OPORTUNIDAD)
        jugarRonda(-1, equiposSegundos, equipos);

        //RONDAS ELIMINATORIAS HASTA BUSCAR AL CAMPEON
        jugarRonda(-2, equiposGanadores, equipos);

    }

    public static void jugarRonda(int i, LinkedList<Equipo> equipos, LinkedList<Equipo> segundos) {
        int rondas = equiposGanadores.size() / 2;
        
         LinkedList<Equipo> equiposFinalistas =  new LinkedList(equiposGanadores); 
        

        while (!equipos.isEmpty()) {
            
            Equipo equipoA = equipos.remove(aleatorio.nextInt(equipos.size()));
            Equipo equipoB = equipos.remove(aleatorio.nextInt(equipos.size()));

            switch (i) {
                case 0:
                    System.out.println("==== DAMOS INICIO A LA PRIMERA RONDA ====");

                    System.out.println("Proceda al partido entre el equipo " + equipoA.getNombre().toUpperCase() + " y el equipo " + equipoB.getNombre().toUpperCase());

                    System.out.println("==== INGRESO DE RESULTADOS DE LA " + (i + 1) + "° RONDA ====");

                    System.out.print("Ingrese puntaje del equipo " + equipoA.getNombre() + " --> ");
                    int puntajea = ingresoTeclado.nextInt();
                    System.out.print("Ingrese puntaje del equipo " + equipoB.getNombre() + " --> ");
                    int puntajeb = ingresoTeclado.nextInt();
                    resultados.add(new Resultado(equipoA, equipoB, puntajea, puntajeb));

                    break;

                case -1:
                    System.out.println("==== DAMOS INICIO A LA RONDA DE RECUPERACION ====");

                    System.out.println("Proceda al partido entre el equipo " + equipoA.getNombre().toUpperCase() + " y el equipo " + equipoB.getNombre().toUpperCase());

                    System.out.println("==== INGRESO DE RESULTADOS DE LA RONDA DE RECUPERACION ====");
                    
                    System.out.print("Ingrese puntaje del equipo " + equipoA.getNombre() + " --> ");
                    int puntajeg = ingresoTeclado.nextInt();
                    System.out.print("Ingrese puntaje del equipo " + equipoB.getNombre() + " --> ");
                    int puntajet = ingresoTeclado.nextInt();
                    resultados.add(new Resultado(equipoA, equipoB, puntajeg, puntajet));
                    

                    break;

                case -2:             

                    System.out.println("==== DAMOS INICIO A LAS RONDAS DE CAMPEONES ====");
                    
                    for (int j = 0; j < rondas; j++) {                        
                        while (!equiposFinalistas.isEmpty()) {
                            Equipo equipoC = equiposFinalistas.remove(aleatorio.nextInt(equiposFinalistas.size()));                            
                            Equipo equipoD = equiposFinalistas.remove(aleatorio.nextInt(equiposFinalistas.size()));

                            System.out.println("Proceda al partido entre el equipo " + equipoC.getNombre().toUpperCase() + " y el equipo " + equipoD.getNombre().toUpperCase());

                            System.out.println("==== INGRESO DE RESULTADOS DE LA RONDA DE CAMPEONES ====");

                            System.out.print("Ingrese puntaje del equipo " + equipoC.getNombre() + " --> ");
                            int puntajel = ingresoTeclado.nextInt();
                            System.out.print("Ingrese puntaje del equipo " + equipoD.getNombre() + " --> ");
                            int puntajem = ingresoTeclado.nextInt();

                            resultados.add(new Resultado(equipoC, equipoD, puntajel, puntajem));
                        }

                        for (Resultado resultado : resultados) {
                            arbolesRondas[arbolesRondas.length -1].agregarGanador(resultado.getGanador());
                            equiposSegundos.add(resultado.getGanador());
                            arbolesRondas[arbolesRondas.length - 1].agregarEliminado(resultado.getPerdedor());
                        }
                        resultados.clear();
                    }

                    System.out.println("===== ARBOL DE GANADORES DE LA RONDA DE CAMPEONES ====");
                    arbolesRondas[arbolesRondas.length - 1].verGanadores();
                    System.out.println("===== ARBOL DE SEGUNDAS OPORTUNIDADES DE LA RONDA DE CAMPEONES ====");
                    arbolesRondas[arbolesRondas.length - 1].verSegundos();
                    System.out.println("===== ARBOL DE ELIMIDADOS DE LA RONDA DE CAMPEONES ====");
                    arbolesRondas[arbolesRondas.length - 1].verEliminados();
                    break;

                default:

                    System.out.println("==== DAMOS INICIO A LA " + (i + 1) + "° RONDA (CATEGORIA 2° OPORTUNIDAD) ====");

                    System.out.println("Proceda al partido entre el equipo " + equipoA.getNombre().toUpperCase() + " y el equipo " + equipoB.getNombre().toUpperCase());

                    System.out.println("==== INGRESO DE RESULTADOS DE LA " + (i + 1) + "° RONDA (CATEGORIA 2° OPORTUNIDAD) ====");

                    System.out.print("Ingrese puntaje del equipo " + equipoA.getNombre() + " --> ");
                    int puntajeA = ingresoTeclado.nextInt();
                    System.out.print("Ingrese puntaje del equipo " + equipoB.getNombre() + " --> ");
                    int puntajeB = ingresoTeclado.nextInt();
                    resultados.add(new Resultado(equipoA, equipoB, puntajeA, puntajeB));

                    equipoA = segundos.remove(aleatorio.nextInt(segundos.size()));
                    equipoB = segundos.remove(aleatorio.nextInt(segundos.size()));

                    System.out.println("==== DAMOS INICIO A LA " + (i + 1) + "° RONDA (CATEGORIA GANADORES) ====");

                    System.out.println("Proceda al partido entre el equipo " + equipoA.getNombre().toUpperCase() + " y el equipo " + equipoB.getNombre().toUpperCase());

                    System.out.println("==== INGRESO DE RESULTADOS DE LA " + (i + 1) + "° RONDA (CATEGORIA GANADORES) ====");

                    System.out.print("Ingrese puntaje del equipo " + equipoA.getNombre() + " --> ");
                    int puntajej = ingresoTeclado.nextInt();
                    System.out.print("Ingrese puntaje del equipo " + equipoB.getNombre() + " --> ");
                    int puntajee = ingresoTeclado.nextInt();
                    resultados.add(new Resultado(equipoA, equipoB, puntajej, puntajee));

            }

        }
        
            switch (i) {
                case 0:
                    arbolesRondas[i] = new ArbolRondas();
                    for (Resultado resultado : resultados) {                        
                        arbolesRondas[i].agregarGanador(resultado.getGanador());
                        equiposGanadores.add(resultado.getGanador());
                        arbolesRondas[i].agregarSegundaOportunidad(resultado.getPerdedor());
                        equiposSegundos.add(resultado.getPerdedor());
                    }
                    System.out.println("===== ARBOL DE GANADORES RONDA 1 =====");
                    arbolesRondas[i].verGanadores();
                    System.out.println("===== ARBOL DE PERDEDORES (PASAN A 2DA OPORTUNIDAD RONDA 1 =====");
                    arbolesRondas[i].verSegundos();
                    break;

                case -1:
                    arbolesRondas[arbolesRondas.length -2] = new ArbolRondas();
                    for (Resultado resultado : resultados) {                        
                        arbolesRondas[arbolesRondas.length -2].agregarGanador(resultado.getGanador());
                        //equiposGanadores.add(resultado.getGanador());
                        arbolesRondas[arbolesRondas.length -2].agregarEliminado(resultado.getPerdedor());                        
                    }
                    System.out.println("===== ARBOL DE GANADORES DE LA RONDA DE RECUPERACION ====");
                    arbolesRondas[arbolesRondas.length -2].verGanadores();
                    System.out.println("===== ARBOL DE SEGUNDAS OPORTUNIDADES DE LA RONDA DE RECUPERACION ====");
                    arbolesRondas[arbolesRondas.length -2].verSegundos();
                    System.out.println("===== ARBOL DE ELIMIDADOS DE LA RONDA DE RECUPERACION ====");
                    arbolesRondas[arbolesRondas.length -2].verEliminados();
                    break;
                case -2:
                    break;
                default:
                    arbolesRondas[i] = new ArbolRondas();
                    for (Resultado resultado : resultados) {                        
                        arbolesRondas[i].agregarGanador(resultado.getGanador());
                        equiposGanadores.add(resultado.getGanador());
                        arbolesRondas[i].agregarSegundaOportunidad(resultado.getPerdedor());
                        equiposSegundos.add(resultado.getPerdedor());
                    }
                    System.out.println("===== ARBOL DE GANADORES " + (i + 1) + " ° RONDA =====");
                    arbolesRondas[i].verGanadores();
                    System.out.println("===== ARBOL DE SEGUNDAS OPORTUNIDADES " + (i + 1) + " ° RONDA =====");
                    arbolesRondas[i].verSegundos();
                    System.out.println("===== ARBOL DE ELIMIDADOS " + (i + 1) + " ° RONDA =====");
                    arbolesRondas[i].verEliminados();
            }
            resultados.clear();
            
        
    }
}
