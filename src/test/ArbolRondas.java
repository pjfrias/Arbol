package test;

public class ArbolRondas {
    private NodoEquipo raiz;
    private NodoEquipo ganadores;
    private NodoEquipo segundos;
    private NodoEquipo eliminados;

    public ArbolRondas() {
        this.raiz = new NodoEquipo();
        this.ganadores = new NodoEquipo();
        this.segundos = new NodoEquipo();
        this.eliminados = new NodoEquipo();
        this.raiz.setDerecha(ganadores);
        this.raiz.setCentral(segundos);
        this.raiz.setIzquierda(eliminados);
    }
    
    public void agregarGanador(Equipo ganador){
        ganadores = insertarNodo(ganadores, ganador);
    }
    
    private NodoEquipo insertarNodo(NodoEquipo nodo, Equipo equipo){
        
        if(nodo == null)
            return new NodoEquipo(equipo);
        
        if(equipo.getPuntaje() > nodo.getEquipo().getPuntaje())
            
            nodo.setIzquierda(insertarNodo(nodo.getIzquierda(), equipo));
        
        else if(equipo.getPuntaje() == nodo.getEquipo().getPuntaje())
            
            nodo.setDerecha(insertarNodo(nodo.getDerecha(), equipo));
        //No va a llegar nunca aca pero lo pongo para que compile
        return nodo;
    }
    
    public void agregarSegundaOportunidad(Equipo segundo){
        segundos = insertarNodo(segundos, segundo);
    }
    
    public void agregarEliminado(Equipo eliminado){
        eliminados = insertarNodo(eliminados, eliminado);
    }
    
    public void verGanadores(){
        imprimirArbol(ganadores, 0);
    }
    
    public void verSegundos(){
        imprimirArbol(ganadores, 0);
    }
    
    public void verEliminados(){
        imprimirArbol(ganadores, 0);
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
