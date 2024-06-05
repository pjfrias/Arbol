
package test;

class ArbolTernario {
    private Nodo raiz;

    public ArbolTernario() {
        this.raiz = new Nodo(null);
    }

   public void registrarResultado(Nodo nodo, Resultado resultado) {
        Equipo ganador = resultado.getGanador();
        Equipo perdedor = resultado.getPerdedor();

        if (nodo.getEquipo() == null) {
            nodo.setEquipo(ganador);
            nodo.setGanadores(new Nodo(ganador));
            nodo.setSegundasOportunidades(new Nodo(perdedor));
        } else if (nodo.getEquipo().equals(ganador)) {
            if (nodo.getGanadores() == null) {
                nodo.setGanadores(new Nodo(ganador));
            } else {
                registrarResultado(nodo.getGanadores(), resultado);
            }
        } else if (nodo.getEquipo().equals(perdedor)) {
            if (nodo.getSegundasOportunidades() == null) {
                nodo.setSegundasOportunidades(new Nodo(perdedor));
            } else {
                registrarResultado(nodo.getSegundasOportunidades(), resultado);
            }
        } else {
            if (nodo.getEliminacion() == null) {
                nodo.setEliminacion(new Nodo(perdedor));
            } else if (nodo.isEliminado()) {
                System.out.println("El equipo " + perdedor.getNombre() + " ha sido eliminado.");
            } else {
                registrarResultado(nodo.getEliminacion(), resultado);
            }
        }
    }

    public void imprimirArbol(Nodo nodo, int nivel) {
        if (nodo != null) {
            System.out.println(repeat(" ", nivel * 4) + "Equipo: " + (nodo.getEquipo() != null ? nodo.getEquipo().getNombre() : "N/A"));
            imprimirArbol(nodo.getGanadores(), nivel + 1);
            imprimirArbol(nodo.getSegundasOportunidades(), nivel + 1);
            imprimirArbol(nodo.getEliminacion(), nivel + 1);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }
    
    public static String repeat(String str, int times) {
        if (str == null || times < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}