package mx.com.dgom.cinemex.android.auditoria.app.protocol;

import java.io.Serializable;

public class Complejo implements Serializable {

    int id_complejo;
    private String uuid;
    private int id_region;
    private int id_tipo_complejo;
    private String txt_nombre;
    private String txt_descripcion;
    private String txt_lat;
    private String txt_lon;
    private String txt_direccion;



    public int getId_complejo() {
        return id_complejo;
    }

    public void setId_complejo(int id_complejo) {
        this.id_complejo = id_complejo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public int getId_tipo_complejo() {
        return id_tipo_complejo;
    }

    public void setId_tipo_complejo(int id_tipo_complejo) {
        this.id_tipo_complejo = id_tipo_complejo;
    }

    public String getTxt_nombre() {
        return txt_nombre;
    }

    public void setTxt_nombre(String txt_nombre) {
        this.txt_nombre = txt_nombre;
    }

    public String getTxt_descripcion() {
        return txt_descripcion;
    }

    public void setTxt_descripcion(String txt_descripcion) {
        this.txt_descripcion = txt_descripcion;
    }

    public String getTxt_lat() {
        return txt_lat;
    }

    public void setTxt_lat(String txt_lat) {
        this.txt_lat = txt_lat;
    }

    public String getTxt_lon() {
        return txt_lon;
    }

    public void setTxt_lon(String txt_lon) {
        this.txt_lon = txt_lon;
    }

    public String getTxt_direccion() {
        return txt_direccion;
    }

    public void setTxt_direccion(String txt_direccion) {
        this.txt_direccion = txt_direccion;
    }

    public int getB_habilitado() {
        return b_habilitado;
    }

    public void setB_habilitado(int b_habilitado) {
        this.b_habilitado = b_habilitado;
    }

    private int b_habilitado;



}
