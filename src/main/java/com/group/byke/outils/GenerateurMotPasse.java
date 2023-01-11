package com.group.byke.outils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerateurMotPasse {

    public static String encode(String mdp) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder.encode(mdp);
    }
}