
package test;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int cantidadEquipos = 0;
        int cantidadRondas = 0;
        boolean ingresoOK = false;
        Scanner ingresoTeclado = new Scanner(System.in);
        
        System.out.println("==== BIENVENIDOS AL TORNEO DE BALONCESTO ====");
        
        while(!ingresoOK){
            System.out.print("Ingrese la cantidad de equipos participantes (4,8,16,32) --> ");
            try{
                cantidadEquipos = ingresoTeclado.nextInt();
                if(cantidadEquipos == 4 || cantidadEquipos == 8 || 
                        cantidadEquipos == 16 || cantidadEquipos == 32){
                    ingresoOK = true;
                }else{
                    System.out.println("El valor ingresado no esta permitido");
                    ingresoOK = false;
                }
            }catch (Exception e){
                System.out.println("Valor mal ingresado, por favor indique un valor entero.");
                ingresoOK = false;
                ingresoTeclado.nextLine();
            }
        }
        
        cantidadRondas = (int) Math.round(Math.sqrt(cantidadEquipos)) /2;
        
        ingresoTeclado.nextLine();
        LinkedList<Equipo> equipos = new LinkedList<>();
        LinkedList<Equipo> equiposGanadores = new LinkedList<>();
        LinkedList<Equipo> equiposSegundos = new LinkedList<>();
        
        for(int i = 0; i < cantidadEquipos; i++) {
            Equipo nuevoEquipo = null;
            System.out.print("Nombre del "+(i+1)+" ° equipo --> ");
            nuevoEquipo = new Equipo(ingresoTeclado.next());
            equipos.add(nuevoEquipo);
        }

        Random aleatorio = new Random();
        LinkedList<Resultado> resultados= new LinkedList<>();
        ArbolRondas[] arbolesRondas = new ArbolRondas[cantidadRondas];
        
        for(int i = 0; i < cantidadRondas; i++) {
            
       // Registrar resultados de cada ronda formando enfrentamientos al azar
        
            if(i == 0 ){
                //PRIMERA RONDA
                

                while(!equipos.isEmpty()){
                    Equipo equipoA = equipos.remove(aleatorio.nextInt(equipos.size()));
                    Equipo equipoB = equipos.remove(aleatorio.nextInt(equipos.size()));
                    
                    System.out.println("==== DAMOS INICIO A LA PRIMERA RONDA ====");

                    System.out.println("Proceda al partido entre el equipo "+equipoA.getNombre().toUpperCase()+" y el equipo "+equipoB.getNombre().toUpperCase());
                    
                    System.out.println("==== INGRESO DE RESULTADOS DE LA "+(i+1)+"° RONDA ====");
                    
                    System.out.print("Ingrese puntaje del equipo "+equipoA.getNombre()+" --> ");
                    int puntajeA = ingresoTeclado.nextInt();
                    System.out.print("Ingrese puntaje del equipo "+equipoB.getNombre()+" --> ");
                    int puntajeB = ingresoTeclado.nextInt();

                    resultados.add(new Resultado(equipoA, equipoB, puntajeA, puntajeB));
                }

                for (Resultado resultado : resultados) {
                    arbolesRondas[i].agregarGanador(resultado.getGanador());
                    equiposGanadores.add(resultado.getGanador());
                    arbolesRondas[i].agregarSegundaOportunidad(resultado.getPerdedor());
                    equiposSegundos.add(resultado.getPerdedor());
                }
                resultados.clear();
                System.out.println("===== ARBOL DE GANADORES RONDA 1 =====");
                arbolesRondas[i].verGanadores();
                System.out.println("===== ARBOL DE PERDEDORES (PASAN A 2DA OPORTUNIDAD RONDA 1 =====");
                arbolesRondas[i].verSegundos();
                
            }else{// A PARTIR DE AHORA JUEGAN AMBAS RAMAS, GANADORES Y SEGUNDOS. LOS PERDEDORES SE VAN MOVIENDO DE RAMAS A SEGUNDOS O ELIMINADOS
            
                // ENFRENTAMIENTOS DENTRO DE LA RAMA SEGUNDOS
                while(!equiposSegundos.isEmpty()){
                    Equipo equipoA = equiposSegundos.remove(aleatorio.nextInt(equiposSegundos.size()));
                    Equipo equipoB = equiposSegundos.remove(aleatorio.nextInt(equiposSegundos.size()));
                    
                    System.out.println("==== DAMOS INICIO A LA "+(i+1)+"° RONDA (CATEGORIA 2° OPORTUNIDAD) ====");

                    System.out.println("Proceda al partido entre el equipo "+equipoA.getNombre().toUpperCase()+" y el equipo "+equipoB.getNombre().toUpperCase());
                    
                    System.out.println("==== INGRESO DE RESULTADOS DE LA "+(i+1)+"° RONDA (CATEGORIA 2° OPORTUNIDAD) ====");
                    
                    System.out.print("Ingrese puntaje del equipo "+equipoA.getNombre()+" --> ");
                    int puntajeA = ingresoTeclado.nextInt();
                    System.out.print("Ingrese puntaje del equipo "+equipoB.getNombre()+" --> ");
                    int puntajeB = ingresoTeclado.nextInt();

                    resultados.add(new Resultado(equipoA, equipoB, puntajeA, puntajeB));
                }
                
                for (Resultado resultado : resultados) {
                    arbolesRondas[i].agregarSegundaOportunidad(resultado.getGanador());
                    equiposSegundos.add(resultado.getGanador());
                    arbolesRondas[i].agregarEliminado(resultado.getPerdedor());
                }
                resultados.clear();
                
                // ENFRENTAMIENTOS DENTRO DE LA RAMA GANADORES
                while(!equiposGanadores.isEmpty()){
                    Equipo equipoA = equiposGanadores.remove(aleatorio.nextInt(equiposGanadores.size()));
                    Equipo equipoB = equiposGanadores.remove(aleatorio.nextInt(equiposGanadores.size()));
                    
                    System.out.println("==== DAMOS INICIO A LA "+(i+1)+"° RONDA (CATEGORIA GANADORES) ====");

                    System.out.println("Proceda al partido entre el equipo "+equipoA.getNombre().toUpperCase()+" y el equipo "+equipoB.getNombre().toUpperCase());
                    
                    System.out.println("==== INGRESO DE RESULTADOS DE LA "+(i+1)+"° RONDA (CATEGORIA GANADORES) ====");
                    
                    System.out.print("Ingrese puntaje del equipo "+equipoA.getNombre()+" --> ");
                    int puntajeA = ingresoTeclado.nextInt();
                    System.out.print("Ingrese puntaje del equipo "+equipoB.getNombre()+" --> ");
                    int puntajeB = ingresoTeclado.nextInt();

                    resultados.add(new Resultado(equipoA, equipoB, puntajeA, puntajeB));
                }
                
                for (Resultado resultado : resultados) {
                    arbolesRondas[i].agregarGanador(resultado.getGanador());
                    equiposGanadores.add(resultado.getGanador());
                    arbolesRondas[i].agregarSegundaOportunidad(resultado.getPerdedor());
                    equiposSegundos.add(resultado.getPerdedor());
                }
                
                System.out.println("===== ARBOL DE GANADORES "+(i+1)+" ° RONDA =====");
                arbolesRondas[i].verGanadores();
                System.out.println("===== ARBOL DE SEGUNDAS OPORTUNIDADES "+(i+1)+" ° RONDA =====");
                arbolesRondas[i].verSegundos();
                System.out.println("===== ARBOL DE ELIMIDADOS "+(i+1)+" ° RONDA =====");
                arbolesRondas[i].verEliminados();
                
            }
        }
        
        //RONDA DE RECUPERACION (SOLO PARTICIPAN QUIENES ESTAN EN SEGUNDA OPORTUNIDAD)
        ArbolRondas arbolRecuperacion = new ArbolRondas();
        
        while(!equiposSegundos.isEmpty()){
            Equipo equipoA = equiposSegundos.remove(aleatorio.nextInt(equiposSegundos.size()));
            Equipo equipoB = equiposSegundos.remove(aleatorio.nextInt(equiposSegundos.size()));

            System.out.println("==== DAMOS INICIO A LA RONDA DE RECUPERACION ====");

            System.out.println("Proceda al partido entre el equipo "+equipoA.getNombre().toUpperCase()+" y el equipo "+equipoB.getNombre().toUpperCase());

            System.out.println("==== INGRESO DE RESULTADOS DE LA RONDA DE RECUPERACION ====");

            System.out.print("Ingrese puntaje del equipo "+equipoA.getNombre()+" --> ");
            int puntajeA = ingresoTeclado.nextInt();
            System.out.print("Ingrese puntaje del equipo "+equipoB.getNombre()+" --> ");
            int puntajeB = ingresoTeclado.nextInt();

            resultados.add(new Resultado(equipoA, equipoB, puntajeA, puntajeB));
        }

        for (Resultado resultado : resultados) {
            arbolRecuperacion.agregarGanador(resultado.getGanador());
            equiposGanadores.add(resultado.getGanador());
            arbolRecuperacion.agregarEliminado(resultado.getPerdedor());
        }
        resultados.clear();
        
        System.out.println("===== ARBOL DE GANADORES DE LA RONDA DE RECUPERACION ====");
        arbolRecuperacion.verGanadores();
        System.out.println("===== ARBOL DE SEGUNDAS OPORTUNIDADES DE LA RONDA DE RECUPERACION ====");
        arbolRecuperacion.verSegundos();
        System.out.println("===== ARBOL DE ELIMIDADOS DE LA RONDA DE RECUPERACION ====");
        arbolRecuperacion.verEliminados();
        
        //RONDAS ELIMINATORIAS HASTA BUSCAR AL CAMPEON
        
        ArbolRondas arbolFinal = new ArbolRondas();
        System.out.println("==== DAMOS INICIO A LAS RONDAS DE CAMPEONES ====");
        int rondas = equiposGanadores.size()/2;
        
        for(int i= 0; i<rondas; i++){
            while(!equiposGanadores.isEmpty()){
                Equipo equipoA = equiposGanadores.remove(aleatorio.nextInt(equiposGanadores.size()));
                Equipo equipoB = equiposGanadores.remove(aleatorio.nextInt(equiposGanadores.size()));

                System.out.println("Proceda al partido entre el equipo "+equipoA.getNombre().toUpperCase()+" y el equipo "+equipoB.getNombre().toUpperCase());

                System.out.println("==== INGRESO DE RESULTADOS DE LA RONDA DE CAMPEONES ====");

                System.out.print("Ingrese puntaje del equipo "+equipoA.getNombre()+" --> ");
                int puntajeA = ingresoTeclado.nextInt();
                System.out.print("Ingrese puntaje del equipo "+equipoB.getNombre()+" --> ");
                int puntajeB = ingresoTeclado.nextInt();

                resultados.add(new Resultado(equipoA, equipoB, puntajeA, puntajeB));
            }

            for (Resultado resultado : resultados) {
                arbolFinal.agregarGanador(resultado.getGanador());
                equiposSegundos.add(resultado.getGanador());
                arbolRecuperacion.agregarEliminado(resultado.getPerdedor());
            }
            resultados.clear();
        }
        
        System.out.println("===== ARBOL DE GANADORES DE LA RONDA DE RECUPERACION ====");
        arbolRecuperacion.verGanadores();
        System.out.println("===== ARBOL DE SEGUNDAS OPORTUNIDADES DE LA RONDA DE RECUPERACION ====");
        arbolRecuperacion.verSegundos();
        System.out.println("===== ARBOL DE ELIMIDADOS DE LA RONDA DE RECUPERACION ====");
        arbolRecuperacion.verEliminados();
        
    }
}
