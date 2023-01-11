package com.group.byke.dto;
// classe qui sert à la réponse
// pour une authentification

public class UtilReponse {

    private int numUtil;
    private String nomUtil;
    private String token;

    public UtilReponse(int numUtil, String  nomUtil,  String token) {
        this.numUtil = numUtil;
        this.nomUtil = nomUtil;
        this.token = token;
    }

    public UtilReponse() {
    }

    public int getNumUtil() {
        return numUtil;
    }

    public void setNumUtil(int numUtil) {
        this.numUtil = numUtil;
    }

    public String getNomUtil() {
        return nomUtil;
    }

    public void setNomUtil(String nomUtil) {
        this.nomUtil = nomUtil;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

