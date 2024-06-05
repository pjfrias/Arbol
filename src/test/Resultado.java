
package test;


class Resultado {
    private Equipo equipo1;
    private Equipo equipo2;
    private int puntaje1;
    private int puntaje2;

    public Resultado(Equipo equipo1, Equipo equipo2, int puntaje1, int puntaje2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.puntaje1 = puntaje1;
        this.puntaje2 = puntaje2;
    }

    public Equipo getGanador() {
        return puntaje1 > puntaje2 ? equipo1 : equipo2;
    }

    public Equipo getPerdedor() {
        return puntaje1 > puntaje2 ? equipo2 : equipo1;
    }
}