package com.group.byke.dto;

import java.util.Date;

public class SuccesResponse {

    private String nomSucces;
    private Date dateObtention;

    public SuccesResponse(String nomSucces, Date dateObtention) {
        this.nomSucces = nomSucces;
        this.dateObtention = dateObtention;
    }

    public SuccesResponse() {
    }

    public String getNomSucces() {
        return nomSucces;
    }

    public void setNomSucces(String nomSucces) {
        this.nomSucces = nomSucces;
    }

    public Date getDateObtention() {
        return dateObtention;
    }

    public void setDateObtention(Date dateObtention) {
        this.dateObtention = dateObtention;
    }
}

