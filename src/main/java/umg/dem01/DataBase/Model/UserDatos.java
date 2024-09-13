package umg.dem01.DataBase.Model;

import umg.dem01.DataBase.DataConnection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatos {
    private int carne;
    private String nombre;
    private String correo;
    private String seccion;
    private String telegramid;
    private boolean activo;

    // Constructor vacío
    public UserDatos() {}

    // Constructor con parámetros
    public UserDatos(int carne, String nombre, String seccion,String  correo, String telegramid,boolean activo) {
        this.carne = carne;
        this.nombre = nombre;
        this.seccion = seccion;
        this.correo= correo;
        this.telegramid = telegramid;
        this.activo = activo ;
    }

    // Getters y Setters
    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSeccion() {
        return seccion;
    }
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelegramid() {
        return telegramid;
    }

    public void setTelegramid(String telegramid) {
        this.telegramid = telegramid;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
























}
