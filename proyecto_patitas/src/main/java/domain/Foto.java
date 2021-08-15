package domain;

public class Foto {
    private String nombre;
    private int ancho;
    private int largo;
    private String url;
    /*TODO: Terminar*/
    //private Calidad calidad;
    //private Normalizador normalizador


    public Foto(String nombre, int ancho, int largo, String url) {
        this.nombre = nombre;
        this.ancho = ancho;
        this.largo = largo;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
