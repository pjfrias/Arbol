
package tadarbol;



public class arbolBinario {
    private int arbol[];
    
    

    public arbolBinario(int i) {
        this.arbol = new int [i];
        for (int j = 0; j < arbol.length; j++) {
            arbol[j]=-1;            
        }
    }
    
    public void insertar(int i){
        int pos = 0;
        if (arbol[pos]==-1){
            arbol[pos]= i;
        }else{
            while(true){
                if(i <= arbol[pos]){
                    if(arbol[2*pos+1]==-1){
                        arbol[2*pos+1]=i;
                        return;
                    }
                    else{                       
                        pos=2*pos+1;
                    }
                }else{
                    if(arbol[2*pos+2]==-1){
                        arbol[2*pos+2]=i;
                        return;
                    }
                    else{                        
                        pos=2*pos+2;
                    }
                }
            }
        }        
    }   
    int indice = 0;
    public void preOrden(int indice){
        
        if (indice >= arbol.length || arbol[indice] == -1) {
            return;
        }

        // Procesar el nodo actual
        System.out.print(arbol[indice] + " ");

        // Recorrer el hijo izquierdo
        preOrden( 2 * indice + 1);

        // Recorrer el hijo derecho
        preOrden( 2 * indice + 2);
    }

//        int cont = 0;
//        while(cont <arbol.length-1){
//            System.out.println(arbol[cont]);
//            if(arbol[2*cont+1]==-1){
//                cont = 2*cont+2;                
//            }else{
//                cont = 2*cont+1;
//            }            
//        }

        
    }


        

   