package test;

public class ArbolRondas {
    private NodoEquipo raiz;
    private NodoEquipo ganadores;
    private NodoEquipo segundos;
    private NodoEquipo eliminados;
    

    public ArbolRondas() {
       this.raiz = null; 
        this.ganadores = null; 
        this.segundos = null; 
        this.eliminados = null;
    }
    
    public void agregarGanador(Equipo ganador){
        ganadores = insertarNodo(ganadores, ganador);
    }
    
    public void agregarSegundaOportunidad(Equipo segundo){
        segundos = insertarNodo(segundos, segundo);
    }
    
    public void agregarEliminado(Equipo eliminado){
        eliminados = insertarNodo(eliminados, eliminado);
    }
    
    private NodoEquipo insertarNodo(NodoEquipo nodo, Equipo equipo){
        
        if(nodo == null)
            return new NodoEquipo(equipo);
        
        if (equipo.getPuntaje() > nodo.getEquipo().getPuntaje()) {
            nodo.setIzquierda(insertarNodo(nodo.getIzquierda(), equipo));
        } else if (equipo.getPuntaje() < nodo.getEquipo().getPuntaje()) {
            nodo.setDerecha(insertarNodo(nodo.getDerecha(), equipo));
        } else {
            nodo.setCentral(insertarNodo(nodo.getCentral(), equipo));
        }
        return nodo;
    }    
    
    public void verGanadores(){
        imprimirArbol(ganadores, 0);
    }
    
    public void verSegundos(){
        imprimirArbol(segundos, 0);
    }
    
    public void verEliminados(){
        imprimirArbol(eliminados, 0);
    }
    
    private void imprimirArbol(NodoEquipo nodo, int nivel) {
        if (nodo != null) {
            System.out.println(repetir(" ", nivel * 4) + "Equipo: " + (nodo.getEquipo() != null ? nodo.getEquipo().getNombre() : "DESCONOCIDO"));
            imprimirArbol(nodo.getIzquierda(), nivel + 1);
            imprimirArbol(nodo.getCentral(), nivel + 1);
            imprimirArbol(nodo.getDerecha(), nivel + 1);
        }
    }
    
    public static String repetir(String str, int times) {
        String texto="";
        for (int i = 0; i < times; i++) {
            texto += " ";
        }
        return texto;
    }
}
