
package tadarbol;

public class NodoEnlazado {
    private int valor;
    private NodoEnlazado izq;
    private NodoEnlazado der;
    
    public NodoEnlazado(int valor){
        this.valor = valor;
        this.izq = null;
        this.der = null;
    }
    
    public NodoEnlazado(){}

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoEnlazado getIzq() {
        return izq;
    }

    public void setIzq(NodoEnlazado izq) {
        this.izq = izq;
    }

    public NodoEnlazado getDer() {
        return der;
    }

    public void setDer(NodoEnlazado der) {
        this.der = der;
    }
}
