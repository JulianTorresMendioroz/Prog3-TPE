public class Paquete {
    private int id;
    private String codigoIdentificador;
    private int peso;
    private boolean contieneAliementos;
    private int nivelUrgencia;

    public Paquete(int id, String codigoIdentificador, int peso, boolean contieneAliementos, int nivelUrgencia) {
        this.id = id;
        this.codigoIdentificador = codigoIdentificador;
        this.peso = peso;
        this.contieneAliementos = contieneAliementos;
        this.nivelUrgencia = nivelUrgencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isContieneAlimentos() {
        return contieneAliementos;
    }

    public void setContieneAliementos(boolean contieneAliementos) {
        this.contieneAliementos = contieneAliementos;
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    public void setNivelUrgencia(int nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }


}
