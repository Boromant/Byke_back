package com.group.byke.controller;

import com.group.byke.domains.EntityUsers;
import com.group.byke.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService unUsersService;

    // AFFICHAGE
    @GetMapping("/getUser")
    public Optional<EntityUsers> getUser(@RequestParam("id") int num_util) {
        Optional<EntityUsers> maUser = null;
        try {
            maUser = unUsersService.listerUser(num_util);

        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return maUser;

    }

    @GetMapping("/getUsers")
    public List<EntityUsers> getUsers() {
        List<EntityUsers> mesUsers = null;
        try {
            mesUsers = unUsersService.listerUsers();

        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return mesUsers;

    }

    // MODIFICATION
    @PostMapping(path ="/modification",  consumes = "application/json")
    public ResponseEntity<?> updateUser(@RequestBody EntityUsers unS) {
        try {
            unUsersService.updateUser(unS);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    // SUPPRESSION
    @PostMapping(path ="/suppression", consumes = "application/json")
    public ResponseEntity<?> deleteUser(@RequestBody EntityUsers unS) {
        try {
            unUsersService.deleteUser(unS);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
}
