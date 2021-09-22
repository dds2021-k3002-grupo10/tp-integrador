package services.refugiosApi.entities;

import com.google.gson.annotations.SerializedName;

public class Ubicacion {
    public String direccion;
    public double latitud;
    @SerializedName("long")
    public double longitud;
}
