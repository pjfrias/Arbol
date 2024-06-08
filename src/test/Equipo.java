
package test;

class Equipo {
    private String nombre;
    private int cantVictorias;
    private int cantDerrotas;
    private int puntaje=0;

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

    public void setPuntaje() {
        puntaje++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo{");
        sb.append("nombre=").append(nombre);
        sb.append(", cantVictorias=").append(cantVictorias);
        sb.append(", cantDerrotas=").append(cantDerrotas);
        sb.append(", puntaje=").append(puntaje);
        sb.append('}');
        return sb.toString();
    }

    
}

