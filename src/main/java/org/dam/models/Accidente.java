package org.dam.models;

public class Accidente {

    private int numExpediente;
    private String fecha;
    private String hora;
    private String localizacion;
    private int numero;
    private int codigoDistrito;
    private String distrito;
    private String tipoAccidente;
    private String estadoMeteorologico;
    private String tipoVehiculo;
    private String tipoPersona;
    private String rangoEdad;
    private String sexo;
    private int codLesividad;
    private String lesividad;
    private int coordenadaX;
    private int coordenadaY;
    private String positivoAlcohol;

    public Accidente(String fecha, int numExpediente, String hora,
                     String localizacion, int numero, int codigoDistrito,
                     String distrito, String tipoAccidente, String estadoMeteorologico,
                     String tipoVehiculo, String tipoPersona, String rangoEdad,
                     String sexo, int codLesividad, String lesividad,
                     int coordenadaX, int coordenadaY, String positivoAlcohol) {
        this.fecha = fecha;
        this.numExpediente = numExpediente;
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





}
