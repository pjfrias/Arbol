
package test;

class Nodo {
    private Equipo equipo;
    private Nodo ganadores;
    private Nodo segundasOportunidades;
    private Nodo eliminacion;

    public Nodo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setGanadores(Nodo ganadores) {
        this.ganadores = ganadores;
    }

    public Nodo getGanadores() {
        return ganadores;
    }

    public void setSegundasOportunidades(Nodo segundasOportunidades) {
        this.segundasOportunidades = segundasOportunidades;
    }

    public Nodo getSegundasOportunidades() {
        return segundasOportunidades;
    }

    public void setEliminacion(Nodo eliminacion) {
        this.eliminacion = eliminacion;
    }

    public Nodo getEliminacion() {
        return eliminacion;
    }
    
    public boolean isEliminado() {
        return eliminacion != null && eliminacion.getEquipo() != null;
    }
}