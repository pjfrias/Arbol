
package test;

class Equipo {
    private String nombre;
    private int cantVictorias;
    private int cantDerrotas;
    private int puntaje;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVictorias() {
        return cantVictorias;
    }

    public void setCantVictorias(int cantVictorias) {
        this.cantVictorias = cantVictorias;
    }

    public int getCantDerrotas() {
        return cantDerrotas;
    }

    public void setCantDerrotas(int cantDerrotas) {
        this.cantDerrotas = cantDerrotas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    
}

