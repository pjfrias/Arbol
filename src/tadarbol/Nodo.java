
package tadarbol;

public class Nodo {
    private Nodo izquierdo;
    private Nodo derecho;
    private int valor;

    public Nodo(Nodo izquierdo, Nodo derecho, int valor) {
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.valor = valor;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
