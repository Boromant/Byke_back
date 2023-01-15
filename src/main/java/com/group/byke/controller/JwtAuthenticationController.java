package com.group.byke.controller;

import com.group.byke.domains.EntityUsers;
import com.group.byke.domains.RegisterRequest;
import com.group.byke.dto.UtilReponse;
import com.group.byke.outils.GenerateurMotPasse;
import com.group.byke.repositories.EntityUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.group.byke.config.JwtTokenUtil;

@RequestMapping("/authentification")
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private EntityUsersRepository unUtilisateurRepository;

    @Autowired
    public JwtAuthenticationController(EntityUsersRepository UtilisateurRepostory) {
        this.unUtilisateurRepository = UtilisateurRepostory;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody EntityUsers unUti)
            throws Exception {
        try {
            UserDetails userDetails= appelAuthentication(unUti.getNomUtil(), unUti.getMotPasse());
            unUti.setNumUtil(unUtilisateurRepository.getIdByNomUtil(unUti.getNomUtil()));
            final String token = jwtTokenUtil.generateToken(userDetails);
            UtilReponse unUtilRe = new UtilReponse(unUti.getNumUtil(), unUti.getNomUtil(), token );
            return ResponseEntity.ok(unUtilRe);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    private UserDetails appelAuthentication(String username, String password) throws Exception {

        try {
            Authentication  authentication = authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(username, password));
            UserDetails userDetails= (UserDetails) authentication.getPrincipal();
            return userDetails;
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest unReg){
        if(unUtilisateurRepository.rechercheNom(unReg.getNomUtil()) != null){
            return ResponseEntity.badRequest().body("Nom d'utilisateur déjà utilisé");
        }
        try {
            EntityUsers unUtil = new EntityUsers();
            unUtil.setNumUtil(unUtilisateurRepository.getLastNumUtil()+1);
            unUtil.setNomUtil(unReg.getNomUtil());
            unUtil.setMotPasse(GenerateurMotPasse.encode(unReg.getMotPasse()));
            unUtil.setRole(unReg.getRole());
            unUtilisateurRepository.save(unUtil);
            return ResponseEntity.ok("Utilisateur enregistré");
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
