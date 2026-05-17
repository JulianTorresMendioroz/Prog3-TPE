public class Camion {
    private int id;
    private String patente;
    private int estaRefrigerado;
    private int cargaMaxima;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getEstaRefrigerado() {
        return estaRefrigerado;
    }

    public void setEstaRefrigerado(int estaRefrigerado) {
        this.estaRefrigerado = estaRefrigerado;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public Camion(int id, String patente, int estaRefrigerado, int cargaMaxima) {
        this.id = id;
        this.patente = patente;
        this.estaRefrigerado = estaRefrigerado;
        this.cargaMaxima = cargaMaxima;

    }
}
