package com.group.byke.service;

import com.group.byke.domains.EntityUsers;
import com.group.byke.outils.GenerateurMotPasse;
import com.group.byke.repositories.EntityUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements IUsersService {

    private final EntityUsersRepository unUsersRepository;

    @Autowired
    public UsersService(EntityUsersRepository UsersRepository) {
        this.unUsersRepository = UsersRepository;
    }

    // AFFICHAGE
    @Override
    public List<EntityUsers> listerUsers() {
        try {
            return unUsersRepository.findAll();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return null;
    }
    @Override
    public Optional<EntityUsers> listerUser(@RequestParam("id") int num_util) {
        try {
            return unUsersRepository.findById(num_util);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return null;
    }

    // MODIFICATION
    @Override
    public void updateUser(EntityUsers unS) {
        try {
            unUsersRepository.updateUser(unS.getNumUtil(), unS.getNomUtil(), GenerateurMotPasse.encode(unS.getMotPasse()), unS.getRole());
        } catch (Exception e) {
           ResponseEntity.notFound().build();
        }
    }

    // SUPPRESSION
    @Override
    public void deleteUser(EntityUsers unS) {
        try {
            unUsersRepository.delete(unS);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
    }
}
