package com.group.byke.dto;
// classe qui sert à la réponse
// pour une authentification

public class UtilReponse {

    private String nomUtil;
    private String token;

    public UtilReponse(String  nomUtil,  String token) {
        this.nomUtil = nomUtil;
        this.token = token;
    }

    public UtilReponse() {
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

