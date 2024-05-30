/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tadarbol;

public class TADArbol {

    public static void main(String[] args) {
     
        Arbol arbol = new Arbol(15);
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(12);
        arbol.insertar(7);
        arbol.insertar(8);
        arbol.insertar(11);
        arbol.insertar(14);
        
        
        System.out.println("====== ARBOL CARGADO EN ARREGLO ======");
        arbol.verArreglo();
        
        System.out.println("====== RECORRIDO EN PREORDER ======");
        arbol.preOrder(0);
        
        System.out.println("====== RECORRIDO EN INORDER ======");
        arbol.inOrder(0);
        
        System.out.println("====== RECORRIDO EN POSTORDER ======");
        arbol.postOrder(0);
        
        System.out.println("====== BUSQUEDA EN ARREGLO ======");
        System.out.println(arbol.buscar(8));
        
    }

}
