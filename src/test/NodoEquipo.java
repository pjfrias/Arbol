
package test;

public class NodoEquipo {
    private Equipo equipo;
    
    
    private NodoEquipo izquierda;
    private NodoEquipo central;
    private NodoEquipo derecha;

    public NodoEquipo() {
    }

    public NodoEquipo(Equipo equipo) {
        this.equipo = equipo;
        this.izquierda = null;
        this.central = null;
        this.derecha = null;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public NodoEquipo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoEquipo izquierda) {
        this.izquierda = izquierda;
    }

    public NodoEquipo getCentral() {
        return central;
    }

    public void setCentral(NodoEquipo central) {
        this.central = central;
    }

    public NodoEquipo getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoEquipo derecha) {
        this.derecha = derecha;
    }

    @Override
    public String toString() {
        return "NodoEquipo{" + "equipo=" + equipo + '}';
    }
    
    
    
}
