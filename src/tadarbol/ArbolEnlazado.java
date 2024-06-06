
package tadarbol;

public class ArbolEnlazado {
    
    private NodoEnlazado raiz;
    
    public ArbolEnlazado(){
        this.raiz = null;
    }
    
    public void insertar(int valor){
        raiz = insertarNodo(raiz, valor);
    }
    
    private NodoEnlazado insertarNodo(NodoEnlazado nodo, int valor){
        
        if(nodo == null)
            return new NodoEnlazado(valor);
        
        if(valor < nodo.getValor())
            nodo.setIzq(insertarNodo(nodo.getIzq(), valor));
        else
            nodo.setDer(insertarNodo(nodo.getDer(), valor));
        
        //No va a llegar nunca aca pero lo pongo para que compile
        return nodo;
    }
    
    public void mostrarArbolEnlazado(){
        System.out.println("==== PREORDER ====");
        if (raiz != null) preOrder();
        System.out.println("++++ INORDER +++++");
        if(raiz != null) inOrder();
        System.out.println("//// POSTORDER ////");
        if(raiz != null) postOrder();
    }
    
    public void preOrder(){
        preOrderRecursivo(raiz);
    }
    
    private void preOrderRecursivo(NodoEnlazado nodo){
        
        if (nodo != null) {
            
            System.out.println(nodo.getValor());
            preOrderRecursivo(nodo.getIzq());
            preOrderRecursivo(nodo.getDer());
        }
    }
    
    public void inOrder(){
        inOrderRecursivo(raiz);
    }
    
    private void inOrderRecursivo(NodoEnlazado nodo){
        
        if (nodo != null) {
            
            preOrderRecursivo(nodo.getIzq());
            System.out.println(nodo.getValor());
            preOrderRecursivo(nodo.getDer());
        }
    }
    
    public void postOrder(){
        postOrderRecursivo(raiz);
    }
    
    private void postOrderRecursivo(NodoEnlazado nodo){
        
        if (nodo != null) {
            
            preOrderRecursivo(nodo.getIzq());            
            preOrderRecursivo(nodo.getDer());
            System.out.println(nodo.getValor());
        }
    }
    
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(NodoEnlazado nodo, int valor) {
        if (nodo == null) {
            return false;
        } else if (valor < nodo.getValor()) {
            return buscarRecursivo(nodo.getIzq(), valor);
        } else if (valor > nodo.getValor()) {
            return buscarRecursivo(nodo.getDer(), valor);
        }

        return true;
    }
}
