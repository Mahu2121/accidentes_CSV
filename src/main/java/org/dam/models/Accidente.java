package org.dam.models;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Accidente {

    private String numExpediente;
    private String fecha;
    private String hora;
    private String localizacion;
    private Double numero;
    private Double codigoDistrito;
    private String distrito;
    private String tipoAccidente;
    private String estadoMeteorologico;
    private String tipoVehiculo;
    private String tipoPersona;
    private String rangoEdad;
    private String sexo;
    private Double codLesividad;
    private String lesividad;
    private Double coordenadaX;
    private Double coordenadaY;
    private String positivoAlcohol;

    public Accidente(
            String numExpediente,
            String fecha,
            String hora,
            String localizacion,
            Double numero,
            Double codigoDistrito,
            String distrito,
            String tipoAccidente,
            String estadoMeteorologico,
            String tipoVehiculo,
            String tipoPersona,
            String rangoEdad,
            String sexo,
            Double codLesividad,
            String lesividad,
            Double coordenadaX,
            Double coordenadaY,
            String positivoAlcohol
    ) {
        this.numExpediente = numExpediente;
        this.fecha = fecha;
        this.hora = hora;
        this.localizacion = localizacion;
        this.numero = numero;
        this.codigoDistrito = codigoDistrito;
        this.distrito = distrito;
        this.tipoAccidente = tipoAccidente;
        this.estadoMeteorologico = estadoMeteorologico;
        this.tipoVehiculo = tipoVehiculo;
        this.tipoPersona = tipoPersona;
        this.rangoEdad = rangoEdad;
        this.sexo = sexo;
        this.codLesividad = codLesividad;
        this.lesividad = lesividad;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.positivoAlcohol = positivoAlcohol;
    }


    public String getFecha() { return fecha; }
    public String getNumExpediente() { return numExpediente; }
    public String getHora() { return hora; }
    public String getLocalizacion() { return localizacion; }
    public Double getNumero() { return numero; }
    public Double getCodigoDistrito() { return codigoDistrito; }
    public String getDistrito() { return distrito; }
    public String getTipoAccidente() { return tipoAccidente; }
    public String getEstadoMeteorologico() { return estadoMeteorologico; }
    public String getTipoVehiculo() { return tipoVehiculo; }
    public String getTipoPersona() { return tipoPersona; }
    public String getRangoEdad() { return rangoEdad; }
    public String getSexo() { return sexo; }
    public Double getCodLesividad() { return codLesividad; }
    public String getLesividad() { return lesividad; }
    public Double getCoordenadaX() { return coordenadaX; }
    public Double getCoordenadaY() { return coordenadaY; }
    public String getPositivoAlcohol() { return positivoAlcohol; }

    public Integer getMes(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(fecha, formatter);
        return localDate.getMonthValue();
    }

    @Override
    public String toString() {
        return "Accidente{" +
                "numExpediente='" + getNumExpediente() + '\'' +
                ", fecha='" + getFecha() + '\'' +
                ", hora='" + getHora() + '\'' +
                ", localizacion='" + getLocalizacion() + '\'' +
                ", numero=" + getNumero() +
                ", codigoDistrito=" + getCodigoDistrito() +
                ", distrito='" + getDistrito() + '\'' +
                ", tipoAccidente='" + getTipoAccidente() + '\'' +
                ", estadoMeteorologico='" + getEstadoMeteorologico() + '\'' +
                ", tipoVehiculo='" + getTipoVehiculo() + '\'' +
                ", tipoPersona='" + getTipoPersona() + '\'' +
                ", rangoEdad='" + getRangoEdad() + '\'' +
                ", sexo='" + getSexo() + '\'' +
                ", codLesividad=" + getCodLesividad() +
                ", lesividad='" + getLesividad() + '\'' +
                ", coordenadaX=" + getCoordenadaX() +
                ", coordenadaY=" + getCoordenadaY() +
                ", positivoAlcohol='" + getPositivoAlcohol() + '\'' +
                '}';
    }
}
