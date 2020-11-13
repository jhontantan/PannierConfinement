package com.i.pannierconfinement;

import java.io.Serializable;


public class Products implements Serializable {

    String idProd;
    String nomProd;
    String desc;
    double prix;


    public Products(String idProd, String nomProd, String desc, double prix) {
        this.idProd = idProd;
        this.nomProd = nomProd;
        this.desc = desc;
        this.prix = prix;
    }


    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}