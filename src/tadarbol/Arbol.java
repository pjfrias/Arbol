/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadarbol;

/**
 *
 * @author 54265
 */
public class Arbol {
    
    private int[] arreglo;

    public Arbol() {
    }

    public Arbol(int tamanio) {
//        int tamanio = (int) Math.pow(grado, nivel)-1;
        this.arreglo = new int[tamanio];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = -1;
        }
    }
    
    public void insertar(int valor){
        int posicion = 0;
        int elemento = arreglo[posicion];
        //recorro el arreglo hasta que encuentro la posicion deseada vacia
        while (elemento != -1){
            if(valor < elemento ){
                //incremento la posicion haciendo saltos dobles por cada iteracion
                //porque deben quedar espacios para los otros nodos
                posicion = (posicion*2) + 1;
            }else{
                posicion = (posicion*2) + 2;
            }
            //rescato el elemento para la proxima comparacion
            elemento = arreglo[posicion];
        }
        //ya ubique la posicion a utilizar y guardo el valor en el arreglo
        arreglo[posicion] = valor;
    }
    
    public void preOrder(int posicion){
        int posMenor = (posicion*2)+1;
        int posMayor = (posicion*2)+2;
        
        System.out.println("["+arreglo[posicion]+"]");
        
        if(posMenor<arreglo.length){
            if(arreglo[posMenor] != -1) preOrder(posMenor);
        }
        if(posMayor<arreglo.length){
            if(arreglo[posMayor] != -1) preOrder(posMayor);
        }
    }
    
    public void inOrder(int posicion){
        int posMenor = (posicion*2)+1;
        int posMayor = (posicion*2)+2;
        
        if(posMenor<arreglo.length){
            if(arreglo[posMenor] != -1) inOrder(posMenor);
        }
        
        System.out.println("["+arreglo[posicion]+"]");
        
        if(posMayor<arreglo.length){
            if(arreglo[posMayor] != -1) inOrder(posMayor);
        }
    }
    
    public void postOrder(int posicion){
        int posMenor = (posicion*2)+1;
        int posMayor = (posicion*2)+2;
        
        if(posMenor<arreglo.length){
            if(arreglo[posMenor] != -1) postOrder(posMenor);
        }
         
        if(posMayor<arreglo.length){
            if(arreglo[posMayor] != -1) postOrder(posMayor);
        }
        
        System.out.println("["+arreglo[posicion]+"]");
    }
     
    public boolean buscar(int valor){
        for (int i : arreglo) {
            if (i == valor) return true;
        }
        return false;
    }
    
    public void verArreglo(){
        for (int i : arreglo) {
            System.out.println("["+i+"]");
        }
    }
    
}
